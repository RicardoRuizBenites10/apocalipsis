Ext.define('GrupoBruce.store.Asistencia', {
    extend: 'Ext.data.Store',
    alias: 'store.Sasistencia',
    model: 'GrupoBruce.model.Asistencia',

    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-TRABAJADOR',
            direction: 'ASC'
        }]
    
});