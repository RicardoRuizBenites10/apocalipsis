Ext.define('GrupoBruce.store.Acceso', {
    extend: 'Ext.data.TreeStore',
    model: 'GrupoBruce.model.Acceso',
    alias: 'store.Sacceso',

    parentIdProperty: 'idSupmenu',
    
    remoteSort: true,
    remoteFilter: true
});