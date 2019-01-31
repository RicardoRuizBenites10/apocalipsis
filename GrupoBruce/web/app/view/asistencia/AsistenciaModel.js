Ext.define('GrupoBruce.view.asistencia.AsistenciaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasistencia',

    data: {
        desde: new Date(),
        pageSize: null
    },

    stores: {
        horarios: {
            type: 'Shorario',
            autoLoad: true
            ,filters: [{
                    property: 'ID_DIA',
                    operator: 'eq',
                    value: '{idDia}'
                }]
        },
        asistencias: {
            type: 'Sasistencia',
            autoLoad: true,
            pageSize: '{pageSize ? pageSize : 25}',
            filters: [{
                    property: 'FECHA',
                    operator: 'eq',
                    value: '{desde}'
                }]
        }
    },

    formulas: {
        idDia: function (get) {
            return get('desde').getDay();
        }
    }

});
