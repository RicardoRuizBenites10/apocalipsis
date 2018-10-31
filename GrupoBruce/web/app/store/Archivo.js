Ext.define('GrupoBruce.store.Archivo', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Archivo',
    alias: 'store.Sarchivo',

    remoteSort: true,
    remoteFilter: true
});