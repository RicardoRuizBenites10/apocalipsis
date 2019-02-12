Ext.define('GrupoBruce.view.concepto.ConceptoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cconcepto',

    createDialog: function (record) {
        var window = new GrupoBruce.view.concepto.FormConcepto();
        var vm = this.getViewModel();
        window.getViewModel().set('selectTipoTrabajador', vm.get('selectTipoTrabajador'));
        window.getViewModel().set('newItem', !record);
        if (!record) {
            window.setTitle('Registrar proceso');
            record = new GrupoBruce.model.Concepto();
            record.set('idTtrabajador', vm.get('selectTipoTrabajador').get('idTtrabajador'));
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addConcepto: function () {
        this.createDialog(null);
    },

    editConcepto: function () {
        var model = this.getViewModel().get('selectConcepto');
        this.createDialog(model);
    },

    deleteConcepto: function () {
        var grid = this.lookupReference('list_concepto');
        var model = grid.getSelection()[0];
        model.erase({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'No se pudo eliminar.');
            }
        });
    },

    onSaveConcepto: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistconcepto');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            Ext.Ajax.request({
                url: 'validaNconcepto',
                jsonData: model.data,
                method: 'POST',
                scope: this,
                success: function (response, opts) {
                    var responseText = Ext.decode(response.responseText);
                    var valida = responseText.success ? responseText.success : !window.getViewModel().get('newItem');
                    if (valida) {
                        model.save({// save the record to the server
                            success: function (model, operation) {
                                grid.getStore().reload();
                                form.reset();
                                window.destroy();
                                Ext.Msg.alert('Success', 'Operación exitosa.')
                            },
                            failure: function (model, operation) {
                                Ext.Msg.alert('Failure', 'Operacion fallada.')
                            }
                        });
                    } else {
                        Ext.Msg.show({
                            title: 'Error',
                            msg: "Ya existe un usuario para el trabajador seleccionado, por favor elija otro.",
                            icon: Ext.Msg.ERROR,
                            botones: Ext.Msg.OK
                        });
                    }
                },
                failurer: function (response, opts) {
                    Ext.Msg.alert('Status', response.status);
                }
            });

        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.');
        }
    },

    onCalculadora: function (btn, value) {
        var formula = btn.up('window').lookupReference('text_formula');
        formula.setValue(formula.getValue() + value);
    },

    onAddFormula: function (btn) {
        this.onCalculadora(btn, btn.up('window').getViewModel().get('selectFormula').get('idConcepto'));
    },

    onSuma: function (btn) {
        this.onCalculadora(btn, '+');
    },

    onResta: function (btn) {
        this.onCalculadora(btn, '-');
    },

    onMultiplicacion: function (btn) {
        this.onCalculadora(btn, '*');
    },

    onDivision: function (btn) {
        this.onCalculadora(btn, '/');
    },

    onParAbierto: function (btn) {
        this.onCalculadora(btn, '(');
    },

    onParCerrado: function (btn) {
        this.onCalculadora(btn, ')');
    },
    
    createWindow: function (view) {
        var model = this.getViewModel().get('selectTipoTrabajador');
        var window = Ext.create(view);
        window.getViewModel().set('recordTipoTrabajador', model);
    },

    onConceptosTipoTrabajador: function () {
        this.createWindow('GrupoBruce.view.conceptoasignado.ConceptoAsignado');
    }

});
