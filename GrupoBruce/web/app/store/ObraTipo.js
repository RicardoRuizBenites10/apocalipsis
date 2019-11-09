Ext.define('GrupoBruce.store.ObraTipo',{
    extend: 'Ext.data.Store',
    alias: 'store.Sobratipo',
    model: 'GrupoBruce.model.ObraTipo',
    
    remoteSort: true,
    remoteFilter: true
});