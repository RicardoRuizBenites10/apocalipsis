Ext.define('GrupoBruce.view.tipotrabajador.TipoTrabajadorController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ctipotrabajador',

    createDialog: function (record) {
        var window = new GrupoBruce.view.tipotrabajador.FormTipoTrabajador();
        if (!record) {
            window.setTitle('Registrar tipo trabajador');
            record = new GrupoBruce.model.TipoTrabajador();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addTipoTrabajador: function () {
        this.createDialog(null);
    },

    editTipoTrabajador: function () {
        var model = this.getViewModel().get('selectTipoTrabajador');
        this.createDialog(model);
    },

    onSaveTipoTrabajador: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wtipotrabajador');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            var chkrpensionario = this.lookupReference('chk_rpensionario'), 
                    chkctacts = this.lookupReference('chk_ctacts'),
                    chkdiario = this.lookupReference('chk_jornaldiario');
            model.set('hasrpensionario', chkrpensionario.checked);
            model.set('hasctacts', chkctacts.checked);
            model.set('jornalDiario', chkdiario.checked);
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

    deleteTipoTrabajador: function () {
        var grid = this.lookupReference('list_tipoTrabajador');
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
        var model = this.getViewModel().get('selectTipoTrabajador');
        var window = Ext.create(view);
        window.getViewModel().set('recordTipoTrabajador', model);
    },
    
    onPPlanillaTipoTrabajador: function(){
        this.createWindow('GrupoBruce.view.periodoplanilla.PeriodoPlanilla');
    }
});
