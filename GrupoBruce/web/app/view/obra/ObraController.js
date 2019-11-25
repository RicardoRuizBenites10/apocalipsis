Ext.define('GrupoBruce.view.obra.ObraController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cobra',

    createDialog: function (record) {
        var window = new GrupoBruce.view.obra.FormObra();
        if (!record) {
            window.setTitle('Registrar orden de producción');
            record = new GrupoBruce.model.Obra();
        }
        window.down('form').loadRecord(record);
        window.show();
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

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var chkrpensionario = this.lookupReference('chk_rpensionario');
            model.set('hasrpensionario', chkrpensionario.checked);
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
        Ext.Ajax.request({
            url: 'obras',
            parameters: '',
            method: 'POST',
            async: false,
            params: {ID_CARMOD: mod.get('idCarmod'), ID_CARTIP: tip.get('idCartip'), ID_CARFAL: fal.get('idCarfal')},
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                codigo = responseText.data;
                codigoNum = codigo.substr(4, 3);
            },
            failurer: function (response, opts) {
                console.log('Joder 2');
            }
        });
    }

});
