Ext.define('GrupoBruce.view.materialsubfamilia.MaterialSubfamiliaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmaterialsubfamilia',

    createDialog: function (record) {
        var window = new GrupoBruce.view.materialsubfamilia.FormMaterialSubfamilia();
        if (!record) {
            window.setTitle('Registrar subfamilia material');
            var idFamilia = this.getViewModel().get('recordMaterialFamilia').get('idFamilia');
            record = new GrupoBruce.model.MaterialSubfamilia();
            record.set('idFamilia', idFamilia);
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addMaterialSubfamilia: function () {
        this.createDialog(null);
    },

    editMaterialSubfamilia: function () {
        var model = this.getViewModel().get('selectMaterialSubfamilia');
        this.createDialog(model);
    },

    onSaveMaterialSubfamilia: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistmaterialsubfamilia');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.getViewModel().get('chk_situacionmaterialsubfamilia').checked;
            model.set('situacion',situacion);
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

    deleteMaterialSubfamilia: function () {
        var grid = this.lookupReference('list_materialsubfamilia');
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
