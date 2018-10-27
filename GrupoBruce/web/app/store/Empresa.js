Ext.define('GrupoBruce.store.Empresa',{
    extend: 'Ext.data.Store',
    alias: 'store.Sempresa',
    model: 'GrupoBruce.model.Empresa',
    
    remoteSort: true,
    remoteFilters: true
});