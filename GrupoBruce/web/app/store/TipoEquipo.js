Ext.define('GrupoBruce.store.TipoEquipo', {
    extend: 'Ext.data.Store',
    alias: 'store.StipoEquipo',
    model: 'GrupoBruce.model.TipoEquipo',

    remoteSort: true,
    remoteFilter: true
});