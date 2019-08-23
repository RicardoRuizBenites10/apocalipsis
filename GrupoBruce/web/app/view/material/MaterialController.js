Ext.define('GrupoBruce.view.material.MaterialController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmaterial',

    createDialog: function (record) {
        var window = new GrupoBruce.view.material.FormMaterial();
        if (!record) {
            window.setTitle('Registrar material');
            record = new GrupoBruce.model.Material();
            Ext.getCmp('id_wmaterialunidad').getViewModel().set('recordMaterial', record);
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addMaterial: function () {
        this.createDialog(null);
    },

    editMaterial: function () {
        var model = this.getViewModel().get('selectMaterial');
        this.createDialog(model);
    },

    onSaveMaterial: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistmaterial');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var situacion = this.lookupReference('chk_situacionmaterial').checked;
            var calidad = this.lookupReference('chk_materialseguimientocalidad').checked;
            var autoparte = this.lookupReference('chk_materialautoparte').checked;
            var unidadesStore = this.lookupReference('materialunidad').getStore(), hasBase = false;
            model.set('situacion', situacion);
            model.set('segCalidad', calidad);
            model.set('autoparte', autoparte);
            unidadesStore.each(function (item) {
                if (item.get('base'))
                    hasBase = true;
            });
            if (!hasBase) {
                Ext.Msg.alert('Error', 'Debe asignar unidad de medida base.');
                return false;
            }
            model.save({// save the record to the server
                success: function (model, operation) {
                    unidadesStore.sync({
                        success: function (response, operation) {
                            grid.getStore().reload();
                            form.reset();
                            window.destroy();
                            Ext.Msg.alert('Success', 'Operación exitosa.');
                        },
                        failure: function (response, operation) {
                            model.erase();
                            Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                        }
                    });
                },
                failure: function (model, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.')
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteMaterial: function () {
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
