Ext.define('GrupoBruce.view.periodovacacion.PeriodoVacacionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMperiodoVacacion',

    data: {
        titulo: 'Lista de periodos vacación',
        currentDate: new Date()
    },

    stores: {
        periodosVacacion: {
            type: 'SperiodoVacacion',
            autoLoad: true
        }
    },

    formulas: {
        limiteS: function (get) {
            return new Date(get('anio'), 11, 31);
        },
        limiteI: function (get) {
            return new Date(get('anio'), 0, 1);
        }
    }

});
