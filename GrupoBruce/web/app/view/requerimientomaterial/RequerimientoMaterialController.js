Ext.define('GrupoBruce.view.requerimientomaterial.RequerimientoMaterialController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Crequerimientomaterial',

    createDialog: function (record) {
        var window = new GrupoBruce.view.requerimientomaterial.FormRequerimientoMaterial();
        var vmGrid = Ext.getCmp('id_wlistrequerimientomaterial').up('window').getViewModel();
        if (!record) {
            window.setTitle('Agregar material');
            record = new GrupoBruce.model.RequerimientoMaterial();
            record.set('idActividad', vmGrid.get('recordRequerimiento').get('idRequerimiento'));
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addMaterial: function () {
        this.createDialog(null);
    },

    onSaveMaterial: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistrequerimientomaterial');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            var store = grid.getStore();
            form.updateRecord(model); // update the record with the form data
            model.set('material', window.getViewModel().get('selectMaterial').get('nombre'));
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

    deleteMaterial: function () {
        var grid = Ext.getCmp('id_wlistrequerimientomaterial');
        var model = grid.getSelection()[0];
        grid.getStore().remove(model);
    },

    onSaveRequerimientoMaterial: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistrequerimientoactividad');

        var windowVM = window.getViewModel();
        var windowVM2 = Ext.getCmp('id_wlistrequerimientomaterial').up('window').getViewModel();
        var store2 = windowVM2.get('requerimientomaterials');


        var model = windowVM.get('recordRequerimiento');

        var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
        model.set('idUsuario', loggedIn.idUsuario);

        model.save({// save the record to the server
            success: function (model, operation) {
                store2.each(function (item) {
                    item.set('idRequerimiento', model.get('idRequerimiento'));
                });
                if (store2.needsSync !== undefined && store2.needsSync) {
                    store2.sync({
                        success: function (response, operation) {
                            grid.getStore().reload();
                            form.reset();
                            window.destroy();
                            Ext.Msg.alert('Success', 'Operación exitosa.');
                        },
                        failure: function (batch, operation) {
                            model.erase();
                            var msg = '';
                            if (batch.hasException) {
                                for (var i = 0; i < batch.exceptions.length; i++) {
                                    switch (batch.exceptions[i].action) {
                                        case "destroy" :
                                            msg = msg + batch.exceptions[i]._records.length + " Delete, ";
                                            break;
                                        case "update" :
                                            msg = msg + batch.exceptions[i]._records.length + " Update, ";
                                            break;
                                        case "create" :
                                            msg = msg + batch.exceptions[i]._records.length + " Create, ";
                                            break;
                                    }
                                }
                                Ext.Msg.alert("Status", msg + " operation failed!");
                            } else
                                Ext.Msg.alert('Status', 'Changes failed.');
                        }
                    });
                } else {
                    grid.getStore().reload();
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                }
            },
            failure: function (model, operation) {
                Ext.Msg.alert('Failure', 'Operacion fallada.')
            }
        });
    }

});
