Ext.define('GrupoBruce.view.formacion.FormacionController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cformacion',

    createDialog: function (record) {
        var window = new GrupoBruce.view.formacion.FormFormacion();
        if (!record) {
            window.setTitle('Registrar estudio');
            var idTrabajador = this.getViewModel().get('recordTrabajador').get('idTrabajador');
            var record = Ext.create('GrupoBruce.model.Formacion', {
                idTrabajador: idTrabajador
            });
        }
        window.down('form').loadRecord(record);
    },

    addFormacion: function () {
        this.createDialog(null);
    },

    editFormacion: function () {
        var grid = this.lookupReference('list_formacion');
        var formacion = grid.getSelection()[0];
        this.createDialog(formacion);
    },

    deleteFormacion: function () {
        var grid = this.lookupReference('list_formacion');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (formacion, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.')
            },
            failure: function (formacion, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    },

    onSaveFormacion: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wformacion');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (formacion, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (formacion, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }

});
