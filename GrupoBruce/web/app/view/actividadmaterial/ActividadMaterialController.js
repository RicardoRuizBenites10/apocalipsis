Ext.define('GrupoBruce.view.actividadmaterial.ActividadMaterialController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cactividadmaterial',

    createDialog: function (record) {
        var window = new GrupoBruce.view.actividadmaterial.FormActividadMaterial();
        var vmGrid = Ext.getCmp('id_wactividadmaterial').getViewModel();
        if (!record) {
            window.setTitle('Agregar material');
            record = new GrupoBruce.model.ActividadMaterial();
            record.set('idActividad',vmGrid.get('recordActividad').get('idActividad'));
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addActividadMaterial: function () {
        this.createDialog(null);
    },

    editActividadMaterial: function () {
        var model = this.getViewModel().get('selectActividadMaterial');
        this.createDialog(model);
    },

    onSaveActividadMaterial: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wactividadmaterial');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            var store = grid.getStore();
            form.updateRecord(model); // update the record with the form data
            model.set('material',window.getViewModel().get('selectMaterial').get('nombre'));
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

    deleteActividadMaterial: function () {
        var grid = Ext.getCmp('id_wactividadmaterial');
        var model = grid.getSelection()[0];
        grid.getStore().remove(model);
    }

});
