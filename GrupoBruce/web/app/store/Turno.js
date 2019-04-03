Ext.define('GrupoBruce.store.Turno',{
    extend: 'Ext.data.Store',
    alias: 'store.Sturno',
    model: 'GrupoBruce.model.Turno',
    
    remoteFilter: true,
    remoteSort: true
});