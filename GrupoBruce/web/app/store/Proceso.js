Ext.define('GrupoBruce.store.Proceso',{
    extend: 'Ext.data.Store',
    alias: 'store.Sproceso',
    model: 'GrupoBruce.model.Proceso',
    
    remoteSort: true,
    remoteFilter: true
});