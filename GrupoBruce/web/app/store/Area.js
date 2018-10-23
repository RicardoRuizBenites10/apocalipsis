Ext.define('GrupoBruce.store.Area', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.Sarea',
    model: 'GrupoBruce.model.Area',

    parentIdProperty: 'parentId',

    remoteSort: true,
    remoteFilters: true

});
