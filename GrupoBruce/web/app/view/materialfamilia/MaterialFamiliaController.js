Ext.define('GrupoBruce.view.materialfamilia.MaterialFamiliaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmaterialfamilia',

    createDialog: function (record) {
        var window = new GrupoBruce.view.materialfamilia.FormMaterialFamilia();
        if (!record) {
            window.setTitle('Registrar familia material');
            record = new GrupoBruce.model.MaterialFamilia();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addMaterialFamilia: function () {
        this.createDialog(null);
    },

    editMaterialFamilia: function () {
        var model = this.getViewModel().get('selectMaterialFamilia');
        this.createDialog(model);
    },

    onSaveMaterialFamilia: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistmaterialfamilia');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacionmaterialfamilia').checked;
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

    deleteMaterialFamilia: function () {
        var grid = this.lookupReference('list_materialfamilia');
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
    },

    createWindow: function (view) {
        var model = this.getViewModel().get('selectMaterialFamilia');
        var window = Ext.create(view);
        window.getViewModel().set('recordMaterialFamilia', model);
    },

    onMaterialSubfamilia: function () {
        this.createWindow('GrupoBruce.view.materialsubfamilia.MaterialSubfamilia');
    }

});
