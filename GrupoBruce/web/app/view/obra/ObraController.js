Ext.define('GrupoBruce.view.obra.ObraController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cobra',

    createDialog: function (record) {
        var window = new GrupoBruce.view.obra.FormObra();
        var vmWindow = window.getViewModel();
        var vmWindow2 = Ext.getCmp('id_wobracontratista').getViewModel();

        vmWindow2.set('newRegister', !record);
        vmWindow.set('newRegister', !record);
        if (!record) {
            window.setTitle('Registrar orden de producción');
            record = new GrupoBruce.model.Obra();
            record.set('idObra', 0);
        }
        vmWindow2.set('recordObra', record);
        vmWindow.set('recordObra', record);
        window.down('form').loadRecord(record);
    },

    addObra: function () {
        this.createDialog(null);
    },

    editObra: function () {
        var model = this.getViewModel().get('selectObra');
        this.createDialog(model);
    },

    onSaveObra: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistobra');
        var model = form.getRecord();
        var windowVM2 = Ext.getCmp('id_wobracontratista').getViewModel();
        var store2 = windowVM2.get('obracontratistas');
        var nuevo = windowVM2.get('newRegister'), exit = false;

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
            model.set('idUsuario', loggedIn.idUsuario);
            model.set('hascontratista', store2.count() > 0);

            Ext.Ajax.request({
                url: 'llObra',
                method: 'POST',
                async: false,
                params: {property: 'NOMBRE', operator: 'eq', value: model.get('nombre')},
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
                                item.set('idObra', model.get('idObra'));
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
                    msg: 'El número de OP ya existe.',
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }

    },

    deleteObra: function () {
        var grid = this.lookupReference('list_obra');
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

    onChangeTOP: function (combo, newValue, oldValue, eOpts) {
        var vm = this.getViewModel();
        if (vm.get('newRegister')) {
            var numOP = 1;
            Ext.Ajax.request({
                url: 'llObra',
                method: 'POST',
                async: false,
                params: {property: 'ID_OBRTIP', operator: 'eq', value: newValue},
                success: function (response, opts) {
                    var responseText = Ext.decode(response.responseText);
                    var op = responseText.data;
                    if (op !== null) {
                        numOP = op.numero + 1;
                    }
                },
                failurer: function (response, opts) {
                    console.log('Error 2');
                }
            });
            vm.set('numeroOP', numOP);
            vm.set('anioOP', vm.get('currentYear'));
        }
    },

    createWindow: function (view) {
        var grid = this.lookupReference('list_obra');
        var record = grid.getSelection()[0];
        var window = Ext.create(view);
        window.getViewModel().set('recordObra', record);
        window.down('form').loadRecord(record);
    },

    onObraPintura: function () {
        this.createWindow('GrupoBruce.view.obrapintura.ObraPintura');
    }
});
