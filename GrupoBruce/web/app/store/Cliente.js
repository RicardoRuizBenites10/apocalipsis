Ext.define('GrupoBruce.store.Cliente',{
    extend: 'Ext.data.Store',
    alias: 'store.Scliente',
    model: 'GrupoBruce.model.Cliente',
    
    remoteSort: true,
    remoteFilter: true
});