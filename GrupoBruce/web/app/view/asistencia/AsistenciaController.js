Ext.define('GrupoBruce.view.asistencia.AsistenciaController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.Casistencia',

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
        var grid = btn.up('WlistAsistencia'), store = grid.getStore(), viewmodel = this.getViewModel();
        var storeED = viewmodel.get('calendarios'), storeHD = viewmodel.get('horarios');
        var scheduleDay = storeHD.getAt(0), currentDay = storeED.getCount() > 0 ? storeED.getAt(0) : scheduleDay;
        var base1, base2, marca1, marca7, difM17, marcacion, libre, diario, horas = 0, minutosBefore, minutosAfter;
        base1 = currentDay.get('horaEntrada'), base2 = currentDay.get('horaSalida'), libre = currentDay.get('libre');

        Ext.util.Format.decimalSeparator = '.';
        store.each(function (item) {
            marca1 = item.get('marca1'), marca7 = item.get('marca7'), diario = item.get('jornalDiario');
            marcacion = marca1 !== null && marca7 !== null;
            if (currentDay.get('especial') === undefined) { //dia normal
                item.set('asistio', !libre ? marcacion : !diario);
            } else {
                item.set('asistio', scheduleDay.get('libre') ? !diario : (libre ? true : marcacion));
            }
            item.set('util', libre ? true : marcacion);
            item.set('stdExtra', !libre);
            if (marcacion) {
                minutosBefore = Ext.Date.diff(marca1, base1, Ext.Date.MINUTE), minutosAfter = Ext.Date.diff(base2, marca7, Ext.Date.MINUTE);
                difM17 = Ext.Date.diff(marca1, marca7, Ext.Date.MINUTE);
                horas = difM17 < 60 ? 0 : (minutosBefore + minutosAfter) / 60;
            } else {
                horas = (Ext.Date.diff(base2, base1, Ext.Date.MINUTE) / 60) + (currentDay.get('refrigerio') ? 0.75 : 0);
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
        var grid = btn.up('WlistAsistencia'), store = grid.getStore();
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
                if (item.get('procesado'))
                    areProccess = areProccess + 1;
                if (item.get('marca7') === null)
                    item.set('ausencia', 4);
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
    },

    createWindow: function (view) {
        var window = Ext.create(view);
        window.setTitle('Registrar marcación');
        var model = this.getViewModel().get('selectAsistencia');
        var record = Ext.create('GrupoBruce.model.Marca', {
            idTrabajador: model.get('idTrabajador'),
            fecha: model.get('fecha')
        });
        window.down('form').loadRecord(record);
        window.getViewModel().set('recordAsistencia', model);
    },

    addMarcacion: function () {
        this.createWindow('GrupoBruce.view.marca.FormMarca');
    }

});
