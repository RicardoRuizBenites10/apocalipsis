Ext.define('GrupoBruce.store.Marca',{
    extend: 'Ext.data.Store',
    alias: 'store.Smarca',
    model: 'GrupoBruce.model.Marca',
    
    remoteFilter: true,
    remoteSort: true
});