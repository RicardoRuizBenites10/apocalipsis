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

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.set('categoria', window.getViewModel().get('selectCategoria').get('nombre'));
            model.set('especificacion', window.getViewModel().get('selectEspecificacion').get('descripcion'));
            console.log(model);
            console.log(grid.getStore());
            grid.getStore().add(model);
            form.reset();
            window.destroy();
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.');
        }
    },

    deleteProformaDetalle: function () {
        var grid = Ext.getCmp('id_wproformadetalle');
        var model = grid.getSelection()[0];
        grid.getStore().remove(model);
    }
});
