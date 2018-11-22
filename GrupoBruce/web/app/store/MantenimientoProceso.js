Ext.define('GrupoBruce.store.MantenimientoProceso', {
    extend: 'Ext.data.Store',
    alias: 'store.SmantenimientoProceso',
    model: 'GrupoBruce.model.MantenimientoProceso',

    remoteSort: true,
    remoteFilter: true
});