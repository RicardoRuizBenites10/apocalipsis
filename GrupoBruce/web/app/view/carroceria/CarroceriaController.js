Ext.define('GrupoBruce.view.carroceria.CarroceriaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccarroceria',

    createDialog: function (record) {
        var window = new GrupoBruce.view.carroceria.FormCarroceria();
        window.getViewModel().set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar modelo de carrocería');
            record = new GrupoBruce.model.Carroceria();
            record.set('idCarfal', '');
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addCarroceria: function () {
        this.createDialog(null);
    },

    editCarroceria: function () {
        var model = this.getViewModel().get('selectCarroceria');
        this.createDialog(model);
    },

    onChangeCodigo: function (combo, newValue, oldValue) {
        var vm = combo.up('window').getViewModel();
        var modCar = vm.get('selectCarroceriaModelo'), tipCar = vm.get('selectCarroceriaTipo'), falCar = vm.get('selectCarroceriaFalda');
        
        if (modCar !== null && tipCar !== null && falCar !== null) {
            console.log('modelo : ');
        }
    },

    onSaveCarroceria: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistcarroceria');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var codigo = window.getViewModel().get('codigo');
            var newRegister = window.getViewModel().get('newRegister');
            if (newRegister) {
                model.set('codigo', codigo);
            }
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

    deleteCarroceria: function () {
        var grid = this.lookupReference('list_carroceria');
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
