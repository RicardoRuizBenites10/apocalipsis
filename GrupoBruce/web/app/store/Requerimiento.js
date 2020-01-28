Ext.define('GrupoBruce.store.Requerimiento',{
    exend: 'Ext.data.Store',
    alias: 'store.Srequerimiento',
    model: 'GrupoBruce.model.Requerimiento',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-ACTIVIDAD',
            direction: 'ASC'
        }]
});