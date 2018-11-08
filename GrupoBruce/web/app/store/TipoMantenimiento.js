Ext.define('GrupoBruce.store.TipoMantenimiento', {
    extend: 'Ext.data.Store',
    alias: 'store.StipoMantenimiento',
    model: 'GrupoBruce.model.TipoMantenimiento',

    remoteSort: true,
    remoteFilter: true
});
