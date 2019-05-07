Ext.define('GrupoBruce.view.chasis.ChasisController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cchasis',

    createDialog: function (record) {
        var window = new GrupoBruce.view.chasis.FormChasis();
        if (!record) {
            var idChapro = this.getViewModel().get('recordChasisProveedor').get('idChapro');
            window.setTitle('Registrar chasis');
            record = new GrupoBruce.model.Chasis();
            record.set('idChapro', idChapro);
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addChasis: function () {
        this.createDialog(null);
    },

    editChasis: function () {
        var model = this.getViewModel().get('selectChasis');
        this.createDialog(model);
    },

    onSaveChasis: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistchasis');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (model, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteChasis: function () {
        var grid = this.lookupReference('list_chasis');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    }


});
