Ext.define('GrupoBruce.view.periodoplanilla.PeriodoPlanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMperiodoplanilla',

    data: {
        recordTipoTrabajador: null,
        selectPeriodoPlanilla: null,
        finicio: null,
        ffin: null
    },

    stores: {
        horarios: {
            type: 'Shorario',
            autoLoad: true,
            filters: [{
                    property: 'T.ACTUAL',
                    operator: 'eq',
                    value: true
                }]
        },
        periodosPlanilla: {
            type: 'SperiodoPlanilla',
            autoLoad: true,
            filters: [{
                    property: 'idTtrabajador',
                    operator: 'eq',
                    value: '{recordTipoTrabajador.idTtrabajador}'
                }]
        }
    },

    formulas: {
        limiteIP: function (get) {
            var fecha = get('finicio');
            return fecha !== null ? Ext.Date.getFirstDateOfMonth(fecha) : null;
        },
        limiteFP: function (get) {
            var fecha = get('finicio');
            return fecha !== null ? Ext.Date.getLastDateOfMonth(fecha) : null;
        },
        diasPeriodo: function (get) {
            var fecha1 = get('finicio'), fecha2 = get('ffin'), fechaTemp, dias = 0;
            var horario = get('horarios'), laborDay, fechaTemp = fecha1;
            if (fecha1 !== null && fecha2 !== null) {
                while (Ext.Date.between(fechaTemp, fecha1, fecha2)) {
                    laborDay = horario.findRecord('idDia', fechaTemp.getDay());
                    dias = dias + (laborDay.get('libre') ? 0 : 1);
                    fechaTemp = Ext.Date.add(fechaTemp, Ext.Date.DAY, 1);
                }
            }
            return dias < 8 ? dias : 30;
        },
        diasTotal: function (get) {
            var fecha1 = get('finicio'), fecha2 = get('ffin');
            return fecha1 !== null && fecha2 !== null ? Ext.Date.diff(fecha1, fecha2, Ext.Date.DAY) + 1 : 0;
        }
    }

});
