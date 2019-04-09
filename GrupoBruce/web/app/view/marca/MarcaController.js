Ext.define('GrupoBruce.view.marca.MarcaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmarca',

    onSaveMarcacion: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var asistencia = window.getViewModel().get('recordAsistencia');
        var marca = form.getRecord();
        var fecha = asistencia.get('fecha'), dia = fecha.getDate(), mes = fecha.getMonth() + 1, anio = fecha.getYear() + 1900;

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(marca); // update the record with the form data
            marca.set('dia', dia);
            marca.set('mes', mes);
            marca.set('anio', anio);

            var movebaleHour = marca.get('hmarca'), minTemp, horaN, minN, tempHour, agregar = true;
            marca.save({// save the record to the server
                success: function (response, operation) {
                    for (var i = 1; i < 7; i++) {
                        horaN = asistencia.get('marca' + i);
                        minTemp = movebaleHour.getHours() * 60 + movebaleHour.getMinutes();
                        if (horaN !== null) {
                            minN = horaN.getHours() * 60 + horaN.getMinutes();
                            if (minN > minTemp) {
                                tempHour = horaN;
                                asistencia.set(('marca' + i), movebaleHour);
                                movebaleHour = tempHour;
                            }
                        } else {
                            if (agregar) {
                                asistencia.set(('marca' + i), movebaleHour);
                                asistencia.set(('marca7'), movebaleHour);
                                agregar = false;
                            }
                        }
                    }
                    asistencia.data.marca1 = asistencia.data.marca1 !== null ? Ext.Date.format(asistencia.data.marca1, 'h:i A') : null;
                    asistencia.data.marca2 = asistencia.data.marca2 !== null ? Ext.Date.format(asistencia.data.marca2, 'h:i A') : null;
                    asistencia.data.marca3 = asistencia.data.marca3 !== null ? Ext.Date.format(asistencia.data.marca3, 'h:i A') : null;
                    asistencia.data.marca4 = asistencia.data.marca4 !== null ? Ext.Date.format(asistencia.data.marca4, 'h:i A') : null;
                    asistencia.data.marca5 = asistencia.data.marca5 !== null ? Ext.Date.format(asistencia.data.marca5, 'h:i A') : null;
                    asistencia.data.marca6 = asistencia.data.marca6 !== null ? Ext.Date.format(asistencia.data.marca6, 'h:i A') : null;
                    asistencia.data.marca7 = asistencia.data.marca7 !== null ? Ext.Date.format(asistencia.data.marca7, 'h:i A') : null;
                    asistencia.data.fecha = asistencia.data.fecha !== null ? Ext.Date.format(asistencia.data.fecha, 'c') : null;
                    asistencia.data.fechaTemp = asistencia.data.fechaTemp !== null ? Ext.Date.format(asistencia.data.fechaTemp, 'c') : null;
                    asistencia.data.ausencia = asistencia.data.ausencia === 0 || asistencia.data.ausencia === 4 ? 1 : asistencia.data.ausencia;
                    asistencia.data.marca = true;
                    Ext.Ajax.request({
                        url: 'uuAsistencia',
                        jsonData: asistencia.data,
                        method: 'POST',
                        success: function (response, operation) {
                            Ext.getCmp('id_wlistasistencia').getStore().reload();
                            window.destroy();
                            Ext.Msg.alert('Success', 'Operación exitosa.');
                        },
                        failure: function (response, operation) {
                            Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                        }
                    });
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.');
        }
    },

    onImportacionFile: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var file, name_file;

        if (form.isValid()) {
            file = form.down('filefield').getEl().down('input[type=file]').dom.files[0];
            name_file = form.down('filefield').value.split('\\').pop();

            if (file !== null) {
                this.getBase64(file).then(data => {
                    var base64 = data.split(',');
                    var file = new GrupoBruce.model.Archivo({
                        nombre: name_file,
                        beforeB64: base64[0],
                        afterB64: base64[1]
                    });
                    file.save({// save the record to the server
                        success: function (response, operation) {
                            name_file = response.data.nombre;
                            window.getViewModel().set('nameFile', name_file);
                            Ext.Msg.alert('Success', 'Importación exitosa');
                        },
                        failure: function (model, operation) {
                            Ext.Msg.alert('Failure', 'Operacion fallada.')
                        }
                    });
                });
            }
        } else {
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }

    },

    getBase64: function (file) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);
        });
    },

    saveImport: function (btn) {
        var grid = btn.up('grid');
        var store = grid.getStore();
        var jsonData = [];
        store.each(function (model) {
            model.data.fecha = Ext.Date.format(model.get('fechaTemp'), 'c');
            model.data.hmarca = Ext.Date.format(model.get('hmarca'), 'h:i A');
            model.data.automatico = true;
            model.data.situacion = true;
            jsonData.push(model.data);
        });

        Ext.Ajax.request({
            url: 'iiMarcaList',
            jsonData: jsonData,
            method: 'POST',
            scope: this,
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                store.removeAll();
                Ext.Msg.alert('Status', responseText.message);
                store.setData(responseText.data);
            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status', response.status);
            }
        });

    }

});
