Ext.define('GrupoBruce.store.Area', {
    extend: 'Ext.data.TreeStore',
    model: 'GrupoBruce.model.Area',
    alias: 'store.Sarea',

    parentIdProperty: 'idSuparea',
    
    remoteSort: true,
    remoteFilter: true
});
