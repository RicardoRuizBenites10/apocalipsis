Ext.define('GrupoBruce.store.TipoPlanilla', {
    extend: 'Ext.data.Store',
    alias: 'store.StipoPlanilla',
    model: 'GrupoBruce.model.TipoPlanilla',

    remoteSort: true,
    remoteFilter: true
});