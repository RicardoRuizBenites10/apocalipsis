Ext.define('GrupoBruce.view.proforma.ProformaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cproforma',

    createDialog: function (record) {
        var window = new GrupoBruce.view.proforma.FormProforma();
        var vmWindow = window.getViewModel();
        var vmWindow2 = Ext.getCmp('id_wproformadetalle').getViewModel();

        vmWindow2.set('newRegister', !record);
        vmWindow.set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar proforma');
            record = new GrupoBruce.model.Proforma();
            record.set('idProforma', 0);
        }
        vmWindow2.set('recordProforma', record);
        vmWindow2.set('recordCarroceria', vmWindow.get('selectCarroceria'));
        vmWindow.set('recordProforma', record);
        window.down('form').loadRecord(record);
        window.show();
    },

    addProforma: function () {
        this.createDialog(null);
    },

    editProforma: function () {
        var model = this.getViewModel().get('selectProforma');
        this.createDialog(model);
    },

    onSaveProforma: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistproforma');
        var grid2 = Ext.getCmp('id_wproformadetalle');
        var model = form.getRecord();
        var windowVM = window.getViewModel();
        var nuevo = windowVM.get('newRegister');

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
            var situacion = this.lookupReference('chk_situacionproforma').checked, usamat = grid2.getStore().count() > 0;
            model.set('idUsuario', loggedIn.idUsuario);
            model.set('usaMaterial', usamat);
            model.set('situacion', situacion);
            model.set('idEproceso', Ext.getCmp('id_treeetapa').getValue())

            model.save({// save the record to the server
                success: function (model, operation) {
                    if (nuevo) {
                        grid2.getStore().each(function (item) {
                            item.set('idProforma', model.get('idProforma'));
                        });
                    }
                    if (nuevo && usamat) {
                        grid2.getStore().sync({
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
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    deleteProforma: function () {
        var grid = this.lookupReference('list_proforma');
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

    onChangeCarroceria: function (combo, newValue, oldValue) {
        var vmWindow = combo.up('window').getViewModel();
        console.log('onChangeCarroceria');
        var vmWindow2 = Ext.getCmp('id_wproformadetalle').getViewModel();
        vmWindow2.set('recordCarroceria', vmWindow.get('selectCarroceria'));
    }

});
