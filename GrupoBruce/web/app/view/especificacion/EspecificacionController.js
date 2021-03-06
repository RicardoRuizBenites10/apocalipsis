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
        }
        vmWindow2.set('recordEspecificacion', record);
        vmWindow.set('recordEspecificacion', record);
        window.down('form').loadRecord(record);
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
        var model = form.getRecord();
        var windowVM2 = Ext.getCmp('id_wespecificacionactividad').getViewModel();
        var store2 = windowVM2.get('especificacionactividads');
        var windowVM = window.getViewModel();
        var nuevo = windowVM.get('newRegister');

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var loggedIn = Ext.decode(localStorage.getItem("sesionUsuario"));
            var situacion = this.lookupReference('chk_situacionespecificacion').checked;
            if (nuevo) {
                model.set('usuInsert', loggedIn.idUsuario);
            }
            model.set('usuUpdate', loggedIn.idUsuario);
            model.set('fechaUpdate', new Date());
            model.set('usaActividad', store2.count() > 0 );
            model.set('situacion', situacion);
            model.set('idEcategoria', Ext.getCmp('id_treecategoria').getValue())

            model.save({// save the record to the server
                success: function (model, operation) {
                    if (nuevo) {
                        store2.each(function (item) {
                            item.set('idEspecificacion', model.get('idEspecificacion'));
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
    },

    changeCheck: function (check, newValue, oldValue) {
        var vm = check.up('grid').up('panel').getViewModel();
        var store = vm.get('especificacions');
        if (newValue) {
            store.addFilter([{
                    property: 'ID_ECATEGORIA',
                    operator: 'in',
                    value: vm.get('categorias')
                }]);
        } else {
            store.clearFilter();
        }
    },

    selectPicker: function (picker, record) {
        var codigos = [];
        codigos.push(record.get('idEcategoria'));
        this.childsString(record, codigos);
        picker.up('grid').up('panel').getViewModel().set('categorias', codigos.toString());
    },

    childsString: function (record, codigos) {
        var childs = record.childNodes;
        if (childs.length === 0) {
            codigos.push(record.get('idEcategoria'));
        } else {
            for (var i = 0; i < childs.length; i++) {
                this.childsString(childs[i], codigos);
            }
        }
    }

});
