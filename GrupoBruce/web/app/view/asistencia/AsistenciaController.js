Ext.define('GrupoBruce.view.asistencia.AsistenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casistencia',

    createDialog: function (record) {
        var window = new GrupoBruce.view.marca.FormMarca();
        if (!record) {
            window.setTitle('Registrar marcación');
            var asistencia = this.getViewModel().get('selectAsistencia');
            var record = Ext.create('GrupoBruce.model.Marca', {
                idTrabajador: asistencia.get('idTrabajador'),
                fecha: asistencia.get('fecha')
            });
        }
        window.down('form').loadRecord(record);
    },

    addMarcacion: function () {
        this.createDialog(null);
    },

    onSaveMarcacion: function (btn) {
        var form = btn.up('form');
        var window = btn.up('window');
        var model = form.getRecord();

        if (form.isValid()) { // make sure the form contains valid data before submitting
            form.updateRecord(model); // update the record with the form data
            model.save({// save the record to the server
                success: function (response, operation) {
                    form.reset();
                    window.destroy();
                    Ext.Msg.alert('Success', 'Operación exitosa.');
                },
                failure: function (response, operation) {
                    Ext.Msg.alert('Failure', 'Operacion fallada.');
                }
            });
        } else { // display error alert if the data is invalid
            Ext.Msg.alert('Datos invalidos', 'Por favor corregir los errores.')
        }
    },

    onMarcaImport: function () {
        var window = new GrupoBruce.view.marca.ListMarcaImport();
    },

    onProcesar: function (btn) {
        var grid = btn.up('WlistAsistencia');
        var store = grid.getStore();
        var stdExtra = !this.getViewModel().get('horarios').getAt(0).get('libre');
        store.each(function (item) {
            item.set('asistio', item.get('marca7') !== null);
            if (item.get('marca7') === null) {
                item.set('ausencia', 4);
            }
            item.set('stdExtra', stdExtra);
            item.set('procesado', true);
        });

        store.sync({
            success: function (response, operation) {
                grid.getStore().reload();
                Ext.Msg.alert('Success', 'Operación exitosa.');
            },
            failure: function (response, operation) {
                Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
            }
        });
    },

    onCalcular: function (btn) {
        var grid = btn.up('WlistAsistencia');
        var store = grid.getStore();
        var diaHorario = this.getViewModel().get('horarios').getAt(0);
        var marca1, marca7;
        var horas = 0, horasBefore, horasAfter, horasReturn;
        Ext.util.Format.decimalSeparator = '.';
        store.each(function (item) {
            marca1 = item.get('marca1'), marca7 = item.get('marca7');
            if (marca1 !== null && marca7 !== null) {
                horasBefore = Ext.Date.diff(marca1, diaHorario.get('horaEntrada'), Ext.Date.MINUTE);
                horasAfter = Ext.Date.diff(diaHorario.get('horaSalida'), marca7, Ext.Date.MINUTE);
                horas = (horasBefore + horasAfter) / 60;
            } else {
                horas = (Ext.Date.diff(diaHorario.get('horaSalida'), diaHorario.get('horaEntrada'), Ext.Date.MINUTE) / 60) + (diaHorario.get('refrigerio') ? 0.75 : 0);
            }
            horasReturn = Ext.util.Format.number(horas, '#.0');
            if (horas >= 0) {
                item.set('hrsExtra', horasReturn - 0.25); //15min en cambiarse
            } else {
                item.set('hrsDscto', horasReturn * -1);
            }
        });
    }

});
