Ext.define('GrupoBruce.store.Concepto', {
    extend: 'Ext.data.Store',
    alias: 'store.Sconcepto',
    model: 'GrupoBruce.model.Concepto',

    remoteSort: true,
    remoteFilter: true
});