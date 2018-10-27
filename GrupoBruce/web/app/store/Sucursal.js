Ext.define('GrupoBruce.store.Sucursal', {
    extend: 'Ext.data.Store',
    alias: 'store.Ssucursal',
    model: 'GrupoBruce.model.Sucursal',

    remoteSort: true,
    remoteFilter: true
});