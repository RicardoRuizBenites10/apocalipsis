Ext.define('GrupoBruce.view.periodoplanilla.PeriodoPlanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMperiodoplanilla',
    data: {
        recordTipoTrabajador: null,
        selectPeriodoPlanilla: null,
        finicio: null,
        ffni: null
    },

    stores: {
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
            var fecha1 = get('finicio'), fecha2 = get('ffin'), dias;
            dias = fecha1 !== null && fecha2 !== null ? Ext.Date.diff(fecha1, fecha2, Ext.Date.DAY) : 0;
            return dias < 8 ? dias : (dias >= 30 ? 30 : dias + 1);
        }
    }

});
