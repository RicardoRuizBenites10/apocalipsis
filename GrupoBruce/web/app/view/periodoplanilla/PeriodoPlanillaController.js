Ext.define('GrupoBruce.view.periodoplanilla.PeriodoPlanillaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cperiodoplanilla',

    createDialog: function (record) {
        var window = new GrupoBruce.view.periodoplanilla.FormPeriodoPlanilla();
        if (!record) {
            window.setTitle('Registrar periodo planilla');
            var tt = this.getViewModel().get('recordTipoTrabajador');
            record = new GrupoBruce.model.PeriodoPlanilla();
            record.set('idTtrabajador', tt.get('idTtrabajador'));
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addPeriodoPlanilla: function () {
        this.createDialog(null);
    },

    editPeriodoPlanilla: function () {
        var model = this.getViewModel().get('selectPeriodoPlanilla');
        this.createDialog(model);
    },

    deletePeriodoPlanilla: function () {
        var grid = this.lookupReference('list_periodoPlanilla');
        var periodoModel = grid.getSelection()[0];
        periodoModel.erase({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Eliminación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Failure', 'No se pudo eliminar.');
            }
        });
    },

    onSavePeriodoPlanilla: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistperiodoplanilla');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var check = this.lookupReference('chk_cerradoPeriodoPlanilla');
            model.set('cerrado', check.checked);
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
    }

});
