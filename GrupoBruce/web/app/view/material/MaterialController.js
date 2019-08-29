Ext.define('GrupoBruce.view.material.MaterialController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cmaterial',

    createDialog: function (record) {
        var window = new GrupoBruce.view.material.FormMaterial();
        var vmMain = Ext.getCmp('id_wmain').getViewModel();
        var vmMUnd = Ext.getCmp('id_wmaterialunidad').getViewModel();

        vmMUnd.set('newRegister', !record);
        window.getViewModel().set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar material');
            record = new GrupoBruce.model.Material();
            record.set('idEmpresa', vmMain.get('selectEmpresa').get('idEmpresa'));
            record.set('idSucursal', vmMain.get('selectSucursal').get('idSucursal'));
            record.set('idUsuario', vmMain.get('thisUsuario').idUsuario);
            record.set('idMaterial', 0);
        }
        vmMUnd.set('recordMaterial', record);

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
        var grid = Ext.getCmp('id_wlistmaterial');
        var form = btn.up('form');
        var window = btn.up('window');
        var model = form.getRecord();
        var nuevo = window.getViewModel().get('newRegister');

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
                    var dada = Ext.getCmp('id_wmaterialunidad').getViewModel().get('materialunidads');
                    if (nuevo) {
                        dada.each(function (item) {
                            item.set('idMaterial', model.get('idMaterial'));
                        });
                        dada.sync({
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
//                            Ext.Msg.show({
//                                title: 'Error',
//                                msg: 'Operación fallada.',
//                                icon: Ext.Msg.ERROR,
//                                botones: Ext.Msg.OK
//                            });
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
                    Ext.Msg.show({
                        title: 'Error',
                        msg: 'Operación fallada.',
                        icon: Ext.Msg.ERROR,
                        botones: Ext.Msg.OK
                    });
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
