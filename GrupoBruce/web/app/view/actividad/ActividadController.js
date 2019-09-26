Ext.define('GrupoBruce.view.actividad.ActividadController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cactividad',

    createDialog: function (record) {
        var window = new GrupoBruce.view.actividad.FormActividad();
        var vmWindow = window.getViewModel();
        var vmGridM = Ext.getCmp('id_wactividadmaterial').getViewModel();

        vmGridM.set('newRegister', !record);
        vmWindow.set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar actividad');
            record = new GrupoBruce.model.Actividad();
            record.set('idActividad', 0);
        } else {
            vmWindow.set('miCodex', record.get('idEproceso'));
        }
        vmGridM.set('recordActividad', record);
        window.down('form').loadRecord(record);
        window.show();
    },

    addActividad: function () {
        this.createDialog(null);
    },

    editActividad: function () {
        var model = this.getViewModel().get('selectActividad');
        this.createDialog(model);
    },

    onSaveActividad: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistactividad');
        var gridAM = Ext.getCmp('id_wactividadmaterial');
        var model = form.getRecord();
        var windowVM = window.getViewModel();
        var nuevo = windowVM.get('newRegister');

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
            var situacion = this.lookupReference('chk_situacionactividad').checked, usamat = gridAM.getStore().count() > 0;
            model.set('idUsuario', loggedIn.idUsuario);
            model.set('usaMaterial', usamat);
            model.set('situacion', situacion);
            model.set('idEproceso', Ext.getCmp('id_treeetapa').getValue())

            model.save({// save the record to the server
                success: function (model, operation) {
                    if (nuevo) {
                        gridAM.getStore().each(function (item) {
                            item.set('idActividad', model.get('idActividad'));
                        });
                    }
                    if (usamat) {
                        gridAM.getStore().sync({
                            success: function (response, operation) {
                                rpta = true;
                                grid.getStore().reload();
                                form.reset();
                                window.destroy();
                                Ext.Msg.alert('Success', 'Operación exitosa.');
                            },
                            failure: function (batch, operation) {
                                model.erase();
                                rpta = false;
                                var msg = '';
                                if (batch.hasException) {
                                    for (var i = 0; i < batch.exceptions.length; i++) {
                                        switch (batch.exceptions[i].action) {
                                            case "destroy" :
                                                console.log(batch.exceptions[i]);
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

    deleteActividad: function () {
        var grid = this.lookupReference('list_actividad');
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
