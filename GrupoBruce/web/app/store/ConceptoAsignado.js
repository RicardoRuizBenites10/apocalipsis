Ext.define('GrupoBruce.store.ConceptoAsignado', {
    extend: 'Ext.data.Store',
    alias: 'store.SconceptoAsignado',
    model: 'GrupoBruce.model.ConceptoAsignado',

    remoteSort: true,
    remoteFilter: true
});