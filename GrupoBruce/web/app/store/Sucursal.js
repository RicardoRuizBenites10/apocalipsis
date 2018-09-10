Ext.define('GrupoBruce.store.Sucursal',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Sucursal',
    alias: 'store.Ssucursal',
    
    pageSize: 0,
    proxy: {
        type: 'ajax',
        api: {
            read: 'sucursalAll'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});