Ext.define('GrupoBruce.store.Mantenimiento', {
    extend: 'Ext.data.Store',
    alias: 'store.Smantenimiento',
    model: 'GrupoBruce.model.Mantenimiento',

    remoteSort: true,
    remoteFilter: true
});
