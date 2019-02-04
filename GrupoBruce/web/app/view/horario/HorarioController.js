Ext.define('GrupoBruce.view.horario.HorarioController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Chorario',

    createDialog: function (record) {
        var window = new GrupoBruce.view.horario.FormHorario();
        if (!record) {
            window.setTitle('Registrar horario laboral');
            record = new GrupoBruce.model.Horario();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addHorario: function () {
        this.createDialog(null);
    },

    editHorario: function () {
        var model = this.getViewModel().get('selectHorario');
        this.createDialog(model);
    },

    deleteHorario: function () {
        var grid = this.lookupReference('list_horario');
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

    onSaveHorario: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlisthorario');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data

            var store = grid.getStore(), valido = true;
            store.each(function (item) {
                if (model.get('idDia') === item.get('idDia') && model.get('idHorario') !== item.get('idHorario')) {
                    valido = false;
                    return false;
                }
            });
            if (valido) {
                var noTrabajaja = this.lookupReference('chk_cerrado').checked;
                var tomaRefrigerio = this.lookupReference('chk_refrigerio').checked;
                model.set('libre', noTrabajaja);
                model.set('refrigerio', noTrabajaja ? false : tomaRefrigerio);
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
                    msg: "No se puede registrar hora para el mismo día",
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }

});
