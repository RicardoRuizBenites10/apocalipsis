Ext.define('GrupoBruce.store.ObraPintura',{
    extend: 'Ext.data.Store',
    alias: 'store.Sobrapintura',
    model: 'GrupoBruce.model.ObraPintura',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-COLORDISENO',
            direction: 'ASC'
    }]
});