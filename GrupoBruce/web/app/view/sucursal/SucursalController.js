Ext.define('GrupoBruce.view.sucursal.SucursalController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Csucursal',

    createDialog: function (record) {
        var window = new GrupoBruce.view.sucursal.FormSucursal();
        if (!record) {
            var idEmpresa = this.getViewModel().get('recordEmpresa').get('idEmpresa');
            window.setTitle('Registrar sucursal');
            record = new GrupoBruce.model.Sucursal();
            record.set('idEmpresa', idEmpresa);
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addSucursal: function () {
        this.createDialog(null);
    },

    editSucursal: function () {
        var model = this.getViewModel().get('selectSucursal');
        this.createDialog(model);
    },

    onSaveSucursal: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wsucursal');
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

    deleteSucursal: function () {
        var grid = this.lookupReference('list_sucursal');
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
