Ext.define('GrupoBruce.store.Area', {
    extend: 'Ext.data.TreeStore',
    alias: 'store.Sarea',
    model: 'GrupoBruce.model.Area',

    parentIdProperty: 'idSuparea',

    folderSort: true,
    remoteSort: true,
    remoteFilters: true

});
