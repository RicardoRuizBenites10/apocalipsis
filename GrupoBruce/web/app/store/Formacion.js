Ext.define('GrupoBruce.store.Formacion',{
    extend : 'Ext.data.Store',
    alias: 'store.Sformacion',
    model: 'GrupoBruce.model.Formacion',
    
    remoteSort: true,
    remoteFilter: true
});