Ext.define('GrupoBruce.store.UnidadMedida',{
    extend: 'Ext.data.Store',
    alias: 'store.SunidadMedida',
    model: 'GrupoBruce.model.UnidadMedida',
    
    remoteSort: true,
    remoteFilter: true
});