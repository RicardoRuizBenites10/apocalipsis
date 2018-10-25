Ext.define('GrupoBruce.store.Sucursal',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Sucursal',
    alias: 'store.Ssucursal',
    
    remoteSort: true,
    remoteFilter: true
    
});