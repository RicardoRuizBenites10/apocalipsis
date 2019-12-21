Ext.define('GrupoBruce.view.colorformula.ColorFormulaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccolorformula',

    createDialog: function (record) {
        var window = new GrupoBruce.view.colorformula.FormColorFormula();
        var vmGrid = Ext.getCmp('id_wcolorformula').getViewModel();
        if (!record) {
            window.setTitle('Agregar fórmula');
            record = new GrupoBruce.model.ColorFormula();
            record.set('idMaterial', 0);
            record.set('idCdiseno', vmGrid.get('recordColorDiseno').get('idCdiseno'));
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addColorFormula: function () {
        this.createDialog(null);
    },

    editColorFormula: function () {
        var model = this.getViewModel().get('selectColorFormula');
        this.createDialog(model);
    },

    onSaveColorFormula: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wcolorformula');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            var store = grid.getStore();
            form.updateRecord(model); // update the record with the form data
            model.set('material', window.getViewModel().get('selectColorFormula').get('nombre'));
            store.add(model);

            var removedRecords = store.getRemovedRecords();
            removedRecords.forEach(function (item, index) {
                if (model.get('idMaterial') === item.get('idMaterial')) {
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

    deleteColorFormula: function () {
        var grid = Ext.getCmp('id_wcolorformula');
        var model = grid.getSelection()[0];
        grid.getStore().remove(model);
    }


});
