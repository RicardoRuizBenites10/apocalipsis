Ext.define('GrupoBruce.store.TipoConcepto', {
    extend: 'Ext.data.Store',
    alias: 'store.StipoConcepto',
    model: 'GrupoBruce.model.TipoConcepto',

    remoteSort: true,
    remoteFilter: true
});