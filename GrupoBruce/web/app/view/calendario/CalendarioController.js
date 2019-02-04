Ext.define('GrupoBruce.view.calendario.CalendarioController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Ccalendario',

    createDialog: function (record) {
        var window = new GrupoBruce.view.calendario.FormCalendario();
        if (!record) {
            window.setTitle('Registrar horario especial');
            record = new GrupoBruce.model.Calendario();
        }
        window.down('form').loadRecord(record);
        window.show();
    },

    addCalendario: function () {
        this.createDialog(null);
    },

    editCalendario: function () {
        var model = this.getViewModel().get('selectCalendario');
        this.createDialog(model);
    },

    deleteCalendario: function () {
        var grid = this.lookupReference('list_calendario');
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

    onSaveCalendario: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var grid = Ext.getCmp('id_wlistcalendario');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data

            var store = grid.getStore(), valido = true;
            store.each(function (item) {
                if (Ext.Date.isEqual(model.get('fecha'), item.get('fecha'))) {
                    valido = false;
                    return false;
                }
            });
            if (valido) {
                var noTrabajaja = this.lookupReference('chk_cerrado').checked;
                model.set('libre', noTrabajaja);
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
                    msg: "No se puede registrar horario especial para la misma fecha.",
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    }

});
