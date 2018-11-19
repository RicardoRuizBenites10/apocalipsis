Ext.define('GrupoBruce.view.cargo.CargoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccargo',

    createDialog: function (record) {
        var view = this.getView();

        this.dialog = view.add({
            xtype: 'WformCargo',
            viewModel: {
                data: {
                    title: record ? 'Editar cargo ' : 'Registrar cargo'
                }
            }
        });
        if (!record) {
            var idArea = this.getViewModel().get('recordArea').get('idArea');
            var record = Ext.create('GrupoBruce.model.Cargo', {
                idArea: idArea
            });
        }
        this.dialog.down('form').loadRecord(record);
        this.dialog.show();
    },

    addCargo: function () {
        this.createDialog(null);
    },

    editCargo: function () {
        var grid = this.lookupReference('list_cargo');
        var cargo = grid.getSelection()[0];
        this.createDialog(cargo);
    },

    onSaveCargo: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = this.lookupReference('list_cargo');
        var cargoModel = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(cargoModel); // update the record with the form data
            cargoModel.save({// save the record to the server
                success: function (cargo, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failure: function (cargo, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteCargo: function () {
        var grid = this.lookupReference('list_cargo');
        var cargo = grid.getSelection()[0];
        cargo.erase({
            success: function (cargo, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (cargo, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    },

    onFunciones: function () {
        this.createWindow('GrupoBruce.view.funcion.Funcion');
    },

    createWindow: function (view) {
        var grid = this.lookupReference('list_cargo');
        var cargo = grid.getSelection()[0];
        var window = Ext.create(view);
        window.getViewModel().set('recordCargo', cargo);
    }

});
