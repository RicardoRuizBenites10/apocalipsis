Ext.define('GrupoBruce.view.colordiseno.ColorDisenoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccolordiseno',

    createDialog: function (record) {
        var window = new GrupoBruce.view.colordiseno.FormColorDiseno();
        var vmWindow = window.getViewModel();
        var vmWindow2 = Ext.getCmp('id_wcolorformula').getViewModel();

        vmWindow2.set('newRegister', !record);
        vmWindow.set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar colores de diseños');
            record = new GrupoBruce.model.ColorDiseno();
            record.set('idCdiseno', '');
            vmWindow.set('idCdiseno', '');
        }
        vmWindow2.set('recordColorDiseno', record);
        vmWindow.set('recordColorDiseno', record);
        window.down('form').loadRecord(record);
    },

    addColorDiseno: function () {
        this.createDialog(null);
    },

    editColorDiseno: function () {
        var model = this.getViewModel().get('selectColorDiseno');
        this.createDialog(model);
    },

    onSaveColorDiseno: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistcolordiseno');
        var model = form.getRecord();
        var windowVM = window.getViewModel();
        var windowVM2 = Ext.getCmp('id_wcolorformula').getViewModel();
        var store2 = windowVM2.get('colorformulas');
        var nuevo = windowVM.get('newRegister'), exit = false;

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.set('fecha', new Date());
            model.set('hasformula', store2.count() > 0);
            
            Ext.Ajax.request({
                url: 'llColorDiseno',
                method: 'POST',
                async: false,
                params: {property: 'idCdiseno', operator: 'eq', value: model.get('idCdiseno')},
                success: function (response, opts) {
                    var responseText = Ext.decode(response.responseText);
                    exit = responseText.data !== null;
                },
                failurer: function (response, opts) {
                    console.log('Error 2');
                }
            });
            
            if ((nuevo && !exit) || (!nuevo && exit)) {
                model.save({// save the record to the server
                    success: function (model, operation) {
                        if (nuevo) {
                            store2.each(function (item) {
                                item.set('idCdiseno', model.get('idCdiseno'));
                            });
                        }
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
            } else {
                Ext.Msg.show({
                    title: 'Error',
                    msg: 'El código ingresado ya existe.',
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }

    },

    deleteColorDiseno: function () {
        var grid = this.lookupReference('list_colordiseno');
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
