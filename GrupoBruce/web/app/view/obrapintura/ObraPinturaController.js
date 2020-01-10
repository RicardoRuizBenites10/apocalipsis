Ext.define('GrupoBruce.view.obrapintura.ObraPinturaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cobrapintura',

    createDialog: function (record) {
        var window = new GrupoBruce.view.obrapintura.FormObraPintura();
        var vmGrid = this.getViewModel();
        if (!record) {
            window.setTitle('Agregar color a orden de producción');
            record = new GrupoBruce.model.ObraPintura();
            record.set('idObra', vmGrid.get('recordObra').get('idObra'));
            record.set('idCdiseno', '');
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addObraPintura: function () {
        this.createDialog(null);
    },

    editObraPintura: function () {
        var model = this.getViewModel().get('selectObraPintura');
        this.createDialog(model);
    },

    onSaveObra2: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistobra');
        var windowVM2 = window.getViewModel();
        var store2 = windowVM2.get('obrapinturas');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data

            var gopintura = this.lookupReference('chk_gopintura').checked;
            model.set('gopintura', gopintura);
            //console.log(usamat);
            model.save({// save the record to the server
                success: function (model, operation) {
                    if (store2.needsSync !== undefined && store2.needsSync) { 
                        store2.sync({
                            success: function (response, operation) {
                                grid.getStore().reload();
                                form.reset();
                                window.destroy();
                                Ext.Msg.alert('Success', 'Operación exitosa.');
                            },
                            failure: function (batch, operation) {
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
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    onSaveObraPintura: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistobrapintura');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            var store = grid.getStore();
            form.updateRecord(model); // update the record with the form data
            model.set('colordiseno', window.getViewModel().get('selectColorDiseno').get('denominacion'));
            model.set('fecha', new Date());
            store.add(model);

            var removedRecords = store.getRemovedRecords();
            removedRecords.forEach(function (item, index) {
                if (model.get('idCdiseno') === item.get('idCdiseno')) {
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

    deleteObraPintura: function () {
        var grid = Ext.getCmp('id_wlistobrapintura');
        var model = grid.getSelection()[0];
        grid.getStore().remove(model);
    }

});
