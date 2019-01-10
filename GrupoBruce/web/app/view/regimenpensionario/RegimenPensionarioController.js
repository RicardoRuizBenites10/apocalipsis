Ext.define('GrupoBruce.view.regimenpensionario.RegimenPensionarioController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cregimenpensionario',

    createDialog: function (record) {
        var window = new GrupoBruce.view.regimenpensionario.FormRegimenPensionario();
        if (!record) {
            window.setTitle('Registrar regimen pensionario');
            record = new GrupoBruce.model.RegimenPensionario();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addRegimenPensionario: function () {
        this.createDialog(null);
    },

    editRegimenPensionario: function () {
        var model = this.getViewModel().get('selectRegimenPensionario');
        this.createDialog(model);
    },

    onSaveRegimenPensionario: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wregimenpensionario');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var chkCuspp = this.lookupReference('chk_cuspp'), chkComision = this.lookupReference('chk_comision');
            model.set('cuspp', chkCuspp.checked);
            model.set('comision', chkComision.checked);
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

    deleteRegimenPensionario: function () {
        var grid = this.lookupReference('list_regimenPensionario');
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

    createWindow: function (view) {
        var model = this.getViewModel().get('selectRegimenPensionario');
        var window = Ext.create(view);
        window.getViewModel().set('recordRegimenPensionario', model);
    },

    onComisionesRegimenPensionario: function () {
        this.createWindow('GrupoBruce.view.comisionrp.Comisionrp');
    }
});
