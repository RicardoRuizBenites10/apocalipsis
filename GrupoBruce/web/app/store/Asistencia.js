Ext.define('GrupoBruce.store.Asistencia', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Asistencia',
    alias: 'store.Sasistencia',

    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'ID_ASISTENCIA',
            direction: 'ASC'
        }]
    
});