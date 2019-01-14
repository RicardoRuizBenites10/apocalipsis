Ext.define('GrupoBruce.view.asistencia.AsistenciaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasistencia',

    data: {
        desde: new Date()
    },

    stores: {
        asistencias: {
            type: 'Sasistencia',
            autoLoad: true,
            filters: [{
                    property: 'FECHA',
                    operator: 'eq',
                    value: '{desde}'
                }]
        }
    },

    formulas: {
//        desde: function (get) {
//            return '02/11/2018';
//        }
    }

});
