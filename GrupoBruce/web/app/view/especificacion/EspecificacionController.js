Ext.define('GrupoBruce.view.especificacion.EspecificacionController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cespecificacion',

    createDialog: function (record) {
        var window = new GrupoBruce.view.especificacion.FormEspecificacion();
        var vmWindow = window.getViewModel();
        var vmWindow2 = Ext.getCmp('id_wespecificacionactividad').getViewModel();

        vmWindow2.set('newRegister', !record);
        vmWindow.set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar especificacion');
            record = new GrupoBruce.model.Especificacion();
            record.set('idEspecificacion', 0);
        } else {
            vmWindow.set('miCodex', record.get('idEspecificacion'));
        }
        vmWindow2.set('recordEspecificacion', record);
        window.down('form').loadRecord(record);
        window.show();
    },

    addEspecificacion: function () {
        this.createDialog(null);
    },

    editEspecificacion: function () {
        var model = this.getViewModel().get('selectEspecificacion');
        this.createDialog(model);
    },

    onSaveEspecificacion: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistespecificacion');
        var grid2 = Ext.getCmp('id_wespecificacionactividad');
        var model = form.getRecord();
        var windowVM = window.getViewModel();
        var nuevo = windowVM.get('newRegister');

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
            var situacion = this.lookupReference('chk_situacionespecificacion').checked, usaact = grid2.getStore().count() > 0;
            model.set('usuUpdate', loggedIn.idUsuario);
            model.set('usaActividad', usaact);
            model.set('situacion', situacion);
            model.set('idEcategoria', Ext.getCmp('id_treecategoria').getValue())

            model.save({// save the record to the server
                success: function (model, operation) {
                    if (nuevo) {
                        grid2.getStore().each(function (item) {
                            item.set('idEspecificacion', model.get('idEspecificacion'));
                        });
                    }
                    if (nuevo && usaact) {
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

    deleteEspecificacion: function () {
        var grid = this.lookupReference('list_especificacion');
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
