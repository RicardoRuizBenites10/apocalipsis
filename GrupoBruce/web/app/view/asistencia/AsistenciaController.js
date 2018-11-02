Ext.define('GrupoBruce.view.asistencia.AsistenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casistencia',

    createDialog: function (record) {
        var window = new GrupoBruce.view.asistencia.ListMarcas();
        if (!record) {
            record = Ext.create('GrupoBruce.model.Archivo');
        }
        window.down('form').loadRecord(record);
    },

    onImportacionMarcas: function () {
        this.createDialog(null);
    },

    onImportacionFile: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var file, name_file, extension_file;

        if (form.isValid()) {

            file = form.down('filefield').getEl().down('input[type=file]').dom.files[0];
            name_file = form.down('filefield').value.split('\\').pop();
            extension_file = name_file.split('\.').pop();
            
            if (file !== null) {
                this.getBase64(file).then(data => {
                    var mooo = new GrupoBruce.model.Archivo({
                        fileB64: data,
                        nombre: name_file,
                        extension: extension_file
                    });
                    mooo.save({// save the record to the server
                        success: function (response, operation) {
//                            var data = Ext.decode(response.data);
                            console.log(response.data);
                            Ext.Msg.alert('Success', response.data.nombre)
                        },
                        failure: function (model, operation) {
                            Ext.Msg.alert('Failure', 'Operacion fallada.')
                        }
                    });
                });
            }
        } else { // display error alert if the data is invalid
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
    }

});
