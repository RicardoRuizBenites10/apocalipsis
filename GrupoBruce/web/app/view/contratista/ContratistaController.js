Ext.define('GrupoBruce.view.contratista.ContratistaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccontratista',

    createDialog: function (record) {
        var window = new GrupoBruce.view.contratista.FormContratista();
        window.getViewModel().set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar contratista');
            record = new GrupoBruce.model.Contratista();
            record.set('idContratista', '');
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addContratista: function () {
        this.createDialog(null);
    },

    editContratista: function () {
        var model = this.getViewModel().get('selectContratista');
        this.createDialog(model);
    },

    onSaveContratista: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistcontratista');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacioncontratista').checked;
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

    deleteContratista: function () {
        var grid = this.lookupReference('list_contratista');
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
