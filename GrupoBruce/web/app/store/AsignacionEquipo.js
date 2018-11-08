Ext.define('GrupoBruce.store.AsignacionEquipo', {
    extend: 'Ext.data.Store',
    alias: 'store.SasignacionEquipo',
    model: 'GrupoBruce.model.AsignacionEquipo',

    remoteSort: true,
    remoteFilter: true
});