Ext.define('GrupoBruce.store.EstadoTrabajador',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.EstadoTrabajador',
    alias: 'store.SestadoTrabajador',
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'estadoTrabajadorBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});