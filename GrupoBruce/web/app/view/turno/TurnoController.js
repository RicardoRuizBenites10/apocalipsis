Ext.define('GrupoBruce.view.turno.TurnoController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Cturno',

    createDialog: function (record) {
        var window = new GrupoBruce.view.turno.FormTurno();
        if (!record) {
            window.setTitle('Registrar turno');
            record = new GrupoBruce.model.Turno();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addTurno: function () {
        this.createDialog(null);
    },

    editTurno: function () {
        var model = this.getViewModel().get('selectTurno');
        this.createDialog(model);
    },

    onSaveTurno: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wturno');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
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

    deleteTurno: function () {
        var grid = this.lookupReference('list_empresa');
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
        var model = this.getViewModel().get('selectTurno');
        var window = Ext.create(view);
        window.getViewModel().set('recordTurno', model);
    },

    onHorarioTurno: function () {
        this.createWindow('GrupoBruce.view.horario.Horario');
    }

});
