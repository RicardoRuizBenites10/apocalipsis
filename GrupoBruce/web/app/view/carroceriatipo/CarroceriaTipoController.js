Ext.define('GrupoBruce.view.carroceriatipo.CarroceriaTipoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccarroceriatipo',

    createDialog: function (record) {
        var window = new GrupoBruce.view.carroceriatipo.FormCarroceriaTipo();
        window.getViewModel().set('newRegister',!record);
        if (!record) {
            var idCarmod = this.getViewModel().get('recordCarroceriaModelo').get('idCarmod');
            window.setTitle('Registrar subtipo carrocería');
            record = new GrupoBruce.model.CarroceriaTipo();
            record.set('idCartip', '');
            record.set('idCarmod', idCarmod);
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addCarroceriaTipo: function () {
        this.createDialog(null);
    },

    editCarroceriaTipo: function () {
        var model = this.getViewModel().get('selectCarroceriaTipo');
        this.createDialog(model);
    },

    onSaveCarroceriaTipo: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistcarroceriatipo');
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

    deleteCarroceriaTipo: function () {
        var grid = this.lookupReference('list_carroceriatipo');
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
