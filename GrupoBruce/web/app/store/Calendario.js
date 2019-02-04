Ext.define('GrupoBruce.store.Calendario', {
    extend: 'Ext.data.Store',
    alias: 'store.Scalendario',
    model: 'GrupoBruce.model.Calendario',
    
    remoteSort: true,
    remoteFilter: true
});