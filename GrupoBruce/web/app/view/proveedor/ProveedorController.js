Ext.define('GrupoBruce.view.proveedor.ProveedorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cproveedor',

    createDialog: function (record) {
        var window = new GrupoBruce.view.proveedor.FormProveedor();
        window.getViewModel().set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar proveedor');
            record = new GrupoBruce.model.Proveedor();
            record.set('idProveedor', '');
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addProveedor: function () {
        this.createDialog(null);
    },

    editProveedor: function () {
        var model = this.getViewModel().get('selectProveedor');
        this.createDialog(model);
    },

    onSaveProveedor: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistproveedor');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacionproveedor').checked;
            model.set('situacion', situacion);
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

    deleteProveedor: function () {
        var grid = this.lookupReference('list_proveedor');
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
