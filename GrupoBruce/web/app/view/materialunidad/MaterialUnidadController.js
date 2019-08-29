Ext.define('GrupoBruce.view.materialunidad.MaterialUnidadController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmaterialunidad',

    createDialog: function (record) {
        var grid = Ext.getCmp('id_wmaterialunidad'), hasBase = false;
        var window = new GrupoBruce.view.materialunidad.FormMaterialUnidad();
        var vmForm = window.getViewModel();
        var vmGrid = grid.getViewModel();
        if (!record) {
            window.setTitle('Asignar unidad material');
            record = new GrupoBruce.model.MaterialUnidad();
        }
        
        if (!vmGrid.get('newRegister')) record.set('idMaterial', vmGrid.get('recordMaterial').get('idMaterial'));
        grid.getStore().each(function (item) {
            if (item.get('base'))
                hasBase = true;
        });
        vmForm.set('hasBase', hasBase);
        window.down('form').loadRecord(record);
        window.show();
    },

    addMaterialUnidad: function () {
        this.createDialog(null);
    },

    editMaterialUnidad: function () {
        var model = this.getViewModel().get('selectMaterialUnidad');
        this.createDialog(model);
    },

    onSaveMaterialUnidad: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wmaterialunidad');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var base = this.lookupReference('chk_unidadbase').checked;
            model.set('base', base);
            var store = grid.getStore();

            var errorUnidad = false, errorRepit = false;

            store.each(function (item) {
                if (item.get('idUmedida') === model.get('idUmedida'))
                    errorRepit = true;
                if (item.get('base')) {
                    errorUnidad = true;
                }
            });

            errorUnidad = store.getCount() > 0 ? errorUnidad === model.get('base') : !model.get('base');

            if (errorRepit) {
                Ext.Msg.alert('Error', 'Unidad de medida repetida.');
                return false;
            }
            if (errorUnidad) {
                Ext.Msg.alert('Error', 'Es necesario seleccionar unidad medida base.');
                return false;
            }

            store.add(model);
            form.reset();
            window.destroy();


        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteMaterialUnidad: function () {
        var grid = Ext.getCmp('id_wmaterialunidad');
        var model = grid.getSelection()[0];
        var store = grid.getStore();
        store.remove(model);
    }

});
