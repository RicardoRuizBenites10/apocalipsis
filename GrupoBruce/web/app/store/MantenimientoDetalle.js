Ext.define('GrupoBruce.store.MantenimientoDetalle', {
    extend: 'Ext.data.Store',
    alias: 'store.SmantenimientoDetalle',
    model: 'GrupoBruce.model.MantenimientoDetalle',

    remoteSort: true,
    remoteFilter: true
});