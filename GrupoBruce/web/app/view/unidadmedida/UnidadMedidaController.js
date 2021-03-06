Ext.define('GrupoBruce.view.unidadmedida.UnidadMedidaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cunidadmedida',

    createDialog: function (record) {
        var window = new GrupoBruce.view.unidadmedida.FormUnidadMedida();
        window.getViewModel().set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar unidad medida');
            record = new GrupoBruce.model.UnidadMedida();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addUnidadMedida: function () {
        this.createDialog(null);
    },

    editUnidadMedida: function () {
        var model = this.getViewModel().get('selectUnidadMedida');
        this.createDialog(model);
    },

    onSaveUnidadMedida: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistunidadmedida');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacionunidadmedida').checked;
            model.set('situacion',situacion);
            model.save({// save the record to the server
                success: function (model, operation) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.');
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteUnidadMedida: function () {
        var grid = this.lookupReference('list_unidadmedida');
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
