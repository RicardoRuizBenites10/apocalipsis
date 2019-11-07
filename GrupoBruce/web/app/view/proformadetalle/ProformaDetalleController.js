Ext.define('GrupoBruce.view.proformadetalle.ProformaDetalleController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cproformadetalle',

    createDialog: function (record) {
        var window = new GrupoBruce.view.proformadetalle.FormProformaDetalle();
        var vmGrid = Ext.getCmp('id_wproformadetalle').getViewModel();
        if (!record) {
            window.setTitle('Agregar especificación');
            record = new GrupoBruce.model.ProformaDetalle();
            record.set('idProforma', vmGrid.get('recordProforma').get('idProforma'));
        }
        window.down('form').loadRecord(record);
    },

    addProformaDetalle: function () {
        this.createDialog(null);
    },

    editProformaDetalle: function () {
        var model = this.getViewModel().get('selectProformaDetalle');
        this.createDialog(model);
    },

    onSaveProformaDetalle: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wproformadetalle');
        var model = form.getRecord();
        var usuario = Ext.getCmp('id_wmain').getViewModel().get('thisUsuario')

        if (form.isValid()) { // make sure the form contains valid data before submitting
            var store = grid.getStore();
            form.updateRecord(model); // update the record with the form data
            model.set('categoria', window.getViewModel().get('selectCategoria').get('nombre'));
            model.set('especificacion', window.getViewModel().get('selectEspecificacion').get('descripcion'));
            model.set('usuUpdate', usuario.idUsuario);
            store.add(model);

            var removedRecords = store.getRemovedRecords();
            removedRecords.forEach(function (item, index) {
                if (model.get('idEspecificacion') === item.get('idEspecificacion')) {
                    model.set('wasstd', item.get('wasstd'));
                    removedRecords.splice(index, 1);
                }
            });
            store.removed = removedRecords;
            
            form.reset();
            window.destroy();
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.');
        }
    },

    deleteProformaDetalle: function () {
        var grid = Ext.getCmp('id_wproformadetalle');
        var model = grid.getSelection()[0];
        var store = grid.getStore();
        store.remove(model);
    }
});
