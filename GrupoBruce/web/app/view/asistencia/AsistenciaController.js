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

    onCalcular: function (btn) {
        var grid = btn.up('WlistAsistencia');
        var store = grid.getStore();
        var viewmodel = this.getViewModel();
        var diaEspecial = viewmodel.get('calendarios');
        var diaHorario = viewmodel.get('horarios').getAt(0);
        var base1, base2, marca1, marca7;
        if (!diaHorario.get('libre') && diaEspecial.getCount() > 0) {
            base1 = diaEspecial.getAt(0).get('horaEntrada');
            base2 = diaEspecial.getAt(0).get('horaSalida');
        } else {
            base1 = diaHorario.get('horaEntrada');
            base2 = diaHorario.get('horaSalida');
        }
        var horas = 0, minutosBefore, minutosAfter, difM17;
        Ext.util.Format.decimalSeparator = '.';
        store.each(function (item) {
            marca1 = item.get('marca1'), marca7 = item.get('marca7');
            if (marca1 !== null && marca7 !== null) {
                minutosBefore = Ext.Date.diff(marca1, base1, Ext.Date.MINUTE);
                minutosAfter = Ext.Date.diff(base2, marca7, Ext.Date.MINUTE);
                difM17 = Ext.Date.diff(marca1, marca7, Ext.Date.MINUTE);
                horas = difM17 < 60 ? 0 : (minutosBefore + minutosAfter) / 60;
            } else {
                horas = (Ext.Date.diff(base2, base1, Ext.Date.MINUTE) / 60) + (diaHorario.get('refrigerio') ? 0.75 : 0);
            }
            if (horas >= 0) {
                horas = horas - 0.25;//15min en cambiarse
                item.set('hrsExtra', Ext.util.Format.number(horas > 0 ? horas : 0, '#.00'));
            } else {
                item.set('hrsDscto', Ext.util.Format.number(horas * -1, '#.00'));
            }
        });
        viewmodel.set('wasCalculated', true);
    },

    onProcesar: function (btn) {
        var grid = btn.up('WlistAsistencia');
        var store = grid.getStore();
        var stdExtra = !this.getViewModel().get('horarios').getAt(0).get('libre');
        var wasCalculated = this.getViewModel().get('wasCalculated');
        var areProccess = 0;
        if (!wasCalculated) {
            Ext.MessageBox.show({
                title: 'Error',
                msg: 'No se a hecho el cálculo previo.',
                buttons: Ext.Msg.OK,
                icon: Ext.Msg.ERROR
            });
        } else {
            store.each(function (item) {
                if (item.get('procesado')) {
                    areProccess = areProccess + 1;
                }
                item.set('asistio', stdExtra ? item.get('marca7') !== null : !stdExtra);
                if (item.get('marca7') === null) {
                    item.set('ausencia', 4);
                }
                item.set('stdExtra', stdExtra);
                item.set('procesado', true);
            });

            if (areProccess === 0) {
                store.sync({
                    success: function (response, operation) {
                        grid.getStore().reload();
                        Ext.Msg.alert('Success', 'Operación exitosa.');
                    },
                    failure: function (response, operation) {
                        Ext.Msg.alert('Error', 'No se termino con éxito la operación.');
                    }
                });
            } else {
                Ext.MessageBox.show({
                    title: 'Error de procesamiento',
                    msg: 'Se encontro ' + areProccess + ' datos ya procesados.',
                    buttons: Ext.Msg.OK,
                    icon: Ext.Msg.ERROR
                });
            }
        }
    }

});
