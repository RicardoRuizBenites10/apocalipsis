Ext.define('GrupoBruce.view.marca.MarcaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmarca',

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
