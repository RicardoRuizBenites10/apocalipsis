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
                url: 'imports'
            },
            autoLoad: true,
            filters: [{
                    property: 'nameFile',
                    value: '{nameFile}'
                }]
        }
    }

});
