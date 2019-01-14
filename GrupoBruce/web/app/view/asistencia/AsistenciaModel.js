Ext.define('GrupoBruce.view.asistencia.AsistenciaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasistencia',

    data: {
    },

    stores: {
        asistencias: {
            type: 'Sasistencia',
            autoLoad: true,
            filters: [{
                    property: 'fecha',
                    operator: 'eq',
                    value: '{desde}'
                }]
        }
    },

    formulas: {
        desde: function (get) {
            return '2018-11-02';
        }
    }

});
