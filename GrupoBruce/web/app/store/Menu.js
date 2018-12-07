Ext.define('GrupoBruce.store.Menu',{
    extend: 'Ext.data.TreeStore',
    model: 'GrupoBruce.model.Menu',
    alias: 'store.Smenu',
    
    parentIdProperty: 'idSupmenu',
    
    remoteSort: true,
    remoteFilter: true
});