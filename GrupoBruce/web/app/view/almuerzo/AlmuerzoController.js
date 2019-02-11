Ext.define('GrupoBruce.view.almuerzo.AlmuerzoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Calmuerzo',

    createDialog: function (record) {
        var window = new GrupoBruce.view.almuerzo.FormAlmuerzo();
        if (!record) {
            window.setTitle('Registrar almuerzo');
            record = new GrupoBruce.model.Almuerzo();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addAlmuerzo: function () {
        this.createDialog(null);
    },

    editAlmuerzo: function () {
        var model = this.getViewModel().get('selectAlmuerzo');
        this.createDialog(model);
    },

    deleteAlmuerzo: function () {
        var grid = this.lookupReference('list_almuerzo');
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

    onSaveAlmuerzo: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistalmuerzo');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var refri = this.lookupReference('chk_refrigerio'), encom = this.lookupReference('chk_encomedor');
            model.set('refrigerio', refri.checked);
            model.set('enComedor', encom.checked);
            model.data.fecha = Ext.Date.format(model.data.fecha, 'c')
            Ext.Ajax.request({
                url: 'uuAlmuerzo',
                jsonData: model.data,
                method: 'POST',
                scope: this,
                success: function (response, opts) {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.')
                },
                failurer: function (response, opts) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    onProcesar: function (btn) {
        var grid = btn.up('WlistAlmuerzo');
        var panel = grid.up('panel');
        var costo = panel.getViewModel().get('empresas').getAt(0).get('costoMenu');
        var store = grid.getStore();
        store.each(function (model) {
            model.set('procesado', true);
            model.set('costo', costo);
        });
        store.sync({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Operación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
            }
        });

    }

});
