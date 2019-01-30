Ext.define('GrupoBruce.view.concepto.ConceptoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cconcepto',

    createDialog: function (record) {
        var window = new GrupoBruce.view.concepto.FormConcepto();
        if (!record) {
            window.setTitle('Registrar proceso');
            record = new GrupoBruce.model.Concepto();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addConcepto: function () {
        this.createDialog(null);
    },

    editConcepto: function () {
        var model = this.getViewModel().get('selectConcepto');
        this.createDialog(model);
    },

    deleteConcepto: function () {
        var grid = this.lookupReference('list_concepto');
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

    onSaveConcepto: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistconcepto');
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