Ext.define('GrupoBruce.store.Hijo',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Hijo',
    alias: 'store.Shijo',
    
    pageSize: 15,
    remoteSort: true,
    remoteFilter: true
});