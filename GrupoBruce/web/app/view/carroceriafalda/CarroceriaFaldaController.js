Ext.define('GrupoBruce.view.carroceriafalda.CarroceriaFaldaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccarroceriafalda',

    createDialog: function (record) {
        var window = new GrupoBruce.view.carroceriafalda.FormCarroceriaFalda();
        window.getViewModel().set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar modelo de carrocería');
            record = new GrupoBruce.model.CarroceriaFalda();
            record.set('idCarfal', '');
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addCarroceriaFalda: function () {
        this.createDialog(null);
    },

    editCarroceriaFalda: function () {
        var model = this.getViewModel().get('selectCarroceriaFalda');
        this.createDialog(model);
    },

    onSaveCarroceriaFalda: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistcarroceriafalda');
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

    deleteCarroceriaFalda: function () {
        var grid = this.lookupReference('list_carroceriafalda');
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
