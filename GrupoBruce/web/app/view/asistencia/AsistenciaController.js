Ext.define('GrupoBruce.view.asistencia.AsistenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casistencia',

    createDialog: function (record) {
        var window = new GrupoBruce.view.asistencia.ListMarcas();
    },

    onImportacionMarcas: function () {
        this.createDialog(null);
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
                    var mooo = new GrupoBruce.model.Archivo({
                        nombre: name_file,
                        beforeB64: base64[0],
                        afterB64: base64[1]
                    });
                    mooo.save({// save the record to the server
                        success: function (response, operation) {
                            name_file = response.data.nombre;
                            Ext.Msg.alert('Success', 'Importación exitosa');
                            window.getViewModel().set('nameFile', name_file);
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
        var store = btn.up('grid').getStore();
//        store.each(function (rec) {
//            var asistencia = new GrupoBruce.model.Asistencia();
//            asistencia.set('fecha',rec.get('fechaTemp'));
//            asistencia.set('hmarca',rec.get('hmarca'));
//            asistencia.set('idTrabajador',rec.get('idTrabajador'));
//            asistencia.set('anio',rec.get('anio'));
//            asistencia.set('mes',rec.get('mes'));
//            asistencia.set('dia',rec.get('dia'));
//            asistencia.save();
//        });
        
        Ext.Ajax.request({
            url: 'iiAsistenciaList',
            jsonData: {"lista": "store.getData()"},
            method: 'POST',
            scope: this,
            success: function (response, opts) {
//                var responseText = Ext.decode(response.responseText);
//                var fechaInicio = responseText.inicio !== null ? Ext.Date.add(new Date(responseText.inicio), Ext.Date.DAY, 2) : new Date();
//                if (responseText.success) {
//                    this.createDialog(null, fechaInicio);
//                } else {
//                    Ext.Msg.show({
//                        title: 'Error',
//                        msg: "No se puede registrar nuevo contrato",
//                        icon: Ext.Msg.ERROR,
//                        botones: Ext.Msg.OK
//                    });
//                }

            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status', response.status);
            }
        });
        
        
    }

});
