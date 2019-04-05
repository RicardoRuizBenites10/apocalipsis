Ext.define('GrupoBruce.view.horario.HorarioController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Chorario',

    createDialog: function (record) {
        var window = new GrupoBruce.view.horario.FormHorario();
        if (!record) {
            var idTurno = this.getViewModel().get('recordTurno').get('idTurno');
            window.setTitle('Registrar horario laboral');
            record = new GrupoBruce.model.Horario();
            record.set('idDia', '');
            record.set('idTurno', idTurno);
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
        var grid = Ext.getCmp('id_wlisthorario'), store = grid.getStore();
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data

            var valido = true;
            store.each(function (item) {
                if (model.get('idDia') === item.get('idDia') && model.get('idHorario') !== item.get('idHorario')) {
                    valido = false;
                    return false;
                }
            });
            if (valido) {
                var noTrabaja = this.lookupReference('chk_cerrado').checked, tomaRefrigerio = this.lookupReference('chk_refrigerio').checked;
                model.set('libre', noTrabaja);
                model.set('refrigerio', noTrabaja ? false : tomaRefrigerio);
                if (noTrabaja) {
                    model.set('horaEntrada', null);
                    model.set('horaSalida', null);
                }
                model.save({// save the record to the server
                    success: function (response, operation) {
                        var diasL = 0, minL = 0, turno = grid.up('panel').getViewModel().get('recordTurno');
                        
                        store.add(model);
                        store.each(function (item) {
                            diasL = diasL + (item.get('libre') ? 0 : 1);
                            if (!item.get('libre')) {
                                minL = minL + Ext.Date.diff(item.get('horaEntrada'), item.get('horaSalida'), Ext.Date.MINUTE) - (item.get('refrigerio') ? 45 : 0);
                            }
                        });
                        turno.set('dlbSemana', diasL);
                        turno.set('mlbSemana', minL);
                        turno.save();
                        
                        store.reload();
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
