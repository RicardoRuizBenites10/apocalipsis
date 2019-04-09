Ext.define('GrupoBruce.view.asistencia.AsistenciaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasistencia',

    data: {
        selectAsistencia: null,
        desde: new Date(),
        allRecord: false,
        wasCalculated: false
    },

    stores: {
        horarios: {
            type: 'Shorario',
            autoLoad: true,
            filters: [{
                    property: 'ID_DIA',
                    operator: 'eq',
                    value: '{idDia}'
                }, {
                    property: 'T.ACTUAL',
                    operator: 'eq',
                    value: true
                }]
        },
        calendarios: {
            type: 'Scalendario',
            autoLoad: true,
            filters: [{
                    property: 'fecha',
                    operator: 'eq',
                    value: '{desde}'
                }]
        },
        asistencias: {
            type: 'Sasistencia',
            loading: true,
            autoLoad: true,
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
        },
        allowEdit: function (get) {
            var selection = get('selectAsistencia');
            var allow = selection ? selection.get('procesado') : !selection;
            return allow;
        },
        allRecord: function (get) {
            var asistencias = get('asistencias');
            return asistencias.totalCount > 0;
        }
    }

});
