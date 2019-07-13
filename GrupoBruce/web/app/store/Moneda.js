Ext.define('GrupoBruce.store.Moneda', {
    extend: 'Ext.data.Store',
    alias: 'store.Smoneda',
    model: 'GrupoBruce.model.Moneda',

    remoteSort: true,
    remoteFilter: true
});