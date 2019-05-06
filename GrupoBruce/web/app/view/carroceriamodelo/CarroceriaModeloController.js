Ext.define('GrupoBruce.view.carroceriamodelo.CarroceriaModeloController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccarroceriamodelo',

    createDialog: function (record) {
        var window = new GrupoBruce.view.carroceriamodelo.FormCarroceriaModelo();
        window.getViewModel().set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar modelo de carrocería');
            record = new GrupoBruce.model.CarroceriaModelo();
            record.set('idCarmod', '');
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addCarroceriaModelo: function () {
        this.createDialog(null);
    },

    editCarroceriaModelo: function () {
        var model = this.getViewModel().get('selectCarroceriaModelo');
        this.createDialog(model);
    },

    onSaveCarroceriaModelo: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistCarroceriaModel');
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

    deleteCarroceriaModelo: function () {
        var grid = this.lookupReference('list_empresa');
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
    },

    createWindow: function (view) {
        var model = this.getViewModel().get('selectCarroceriaModelo');
        var window = Ext.create(view);
        window.getViewModel().set('recordCarroceriaModelo', model);
    },

    onCarroceriaSubtipo: function () {
        this.createWindow('GrupoBruce.view.sucursal.Sucursal');
    }

});
