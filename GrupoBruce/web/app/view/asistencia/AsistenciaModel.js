Ext.define('GrupoBruce.view.asistencia.AsistenciaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasistencia',

    data: {
        selectAsistencia: null,
        desde: new Date(),
        pageSize: null,
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
        },
        allowEdit: function (get) {
            var selection = get('selectAsistencia');
            var allow = selection ? selection.get('procesado') : !selection;
            return allow;
        }
    }

});
