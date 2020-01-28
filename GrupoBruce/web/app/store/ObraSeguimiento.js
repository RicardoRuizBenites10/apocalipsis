Ext.define('GrupoBruce.store.ObraSeguimiento',{
    extend: 'Ext.data.Store',
    alias: 'store.Sobraseguimiento',
    model: 'GrupoBruce.model.ObraSeguimiento',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-ORDEN',
            direction: 'ASC'
    }]
});