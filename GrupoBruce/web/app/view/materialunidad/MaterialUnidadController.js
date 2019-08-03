Ext.define('GrupoBruce.view.materialunidad.MaterialUnidadController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmaterialunidad',

    createDialog: function (record) {
        var window = new GrupoBruce.view.materialunidad.FormMaterialUnidad();
        if (!record) {
            window.setTitle('Asignar unidad material');
            record = new GrupoBruce.model.MaterialUnidad();
        }
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
            store.add(model);
//            console.log(store.data);
//            console.log(store.count());
//            model.save({// save the record to the server
//                success: function (model, operation) {
////                    grid.getStore().reload();
//                    form.reset();
//                    window.destroy();
//                    Ext.Msg.alert('Success', 'Operación exitosa.')
//                },
//                failure: function (model, operation) {
//                    Ext.Msg.alert('Failure', 'Operacion fallada.')
//                }
//            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteMaterialUnidad: function () {
        var grid = this.lookupReference('list_material');
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
