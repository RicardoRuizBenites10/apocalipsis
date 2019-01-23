Ext.define('GrupoBruce.store.Almuerzo',{
    extend: 'Ext.data.Store',
    alias: 'store.Salmuerzo',
    model: 'GrupoBruce.model.Almuerzo',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-TRABAJADOR',
            direction: 'ASC'
        }]
});