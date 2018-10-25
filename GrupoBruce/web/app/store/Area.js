Ext.define('GrupoBruce.store.Area', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.Sarea',
    model: 'GrupoBruce.model.Area',

    parentIdProperty: 'idSuparea',
    expanded: true,
    folderSort: true,
    remoteSort: true,
    remoteFilters: true

});
