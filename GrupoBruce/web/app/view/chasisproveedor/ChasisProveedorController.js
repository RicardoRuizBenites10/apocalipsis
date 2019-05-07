Ext.define('GrupoBruce.view.chasisproveedor.ChasisProveedorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cchasisproveedor',

    createDialog: function (record) {
        var window = new GrupoBruce.view.chasisproveedor.FormChasisProveedor();
        if (!record) {
            window.setTitle('Registrar proveedor de chasis');
            record = new GrupoBruce.model.ChasisProveedor();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addChasisProveedor: function () {
        this.createDialog(null);
    },

    editChasisProveedor: function () {
        var model = this.getViewModel().get('selectChasisProveedor');
        this.createDialog(model);
    },

    onSaveChasisProveedor: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistchasisproveedor');
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

    deleteChasisProveedor: function () {
        var grid = this.lookupReference('list_chasisproveedor');
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
        var model = this.getViewModel().get('selectChasisProveedor');
        var window = Ext.create(view);
        window.getViewModel().set('recordChasisProveedor', model);
    },

    onChasis: function () {
        this.createWindow('GrupoBruce.view.chasis.Chasis');
    }

});
