Ext.define('GrupoBruce.store.Plantilla',{
    extend: 'Ext.data.Store',
    alias: 'store.Splantilla',
    model: 'GrupoBruce.model.Plantilla',
    
    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'ESPECIFICACION',
            direction: 'ASC'
    }]
});