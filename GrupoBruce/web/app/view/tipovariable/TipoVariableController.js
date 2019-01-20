Ext.define('GrupoBruce.view.tipovariable.TipoVariableController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctipovariable',
    
    createDialog: function (record) {
        var window = new GrupoBruce.view.tipovariable.FormTipoVariable();
        if (!record) {
            window.setTitle('Registrar tipo variable');
            record = new GrupoBruce.model.TipoVariable();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addTipoVariable: function () {
        this.createDialog(null);
    },

    editTipoVariable: function () {
        var model = this.getViewModel().get('selectTipoVariable');
        this.createDialog(model);
    },
    
    deleteTipoVariable: function () {
        var grid = this.lookupReference('list_tipoVariable');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'No se pudo eliminar.');
            }
        });
    },
    
    onSaveTipoVariable: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlisttipovariable');
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
    }

});
