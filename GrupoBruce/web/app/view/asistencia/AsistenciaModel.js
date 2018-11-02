Ext.define('GrupoBruce.view.asistencia.AsistenciaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasistencia',

    data: {
        nameFile: null
    },

    stores: {
        importacions: {
            type: 'Sasistencia',
            proxy: {
                type: 'ajax',
                url: 'imports',
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                    totalProperty: 'total'
                },
                writer: {
                    type: 'json',
                    writeAllFields: true
                }
            },
            filters: [{
                    property: 'nameFile',
                    value: '{nameFile}'
                }]
        }
    }

});
