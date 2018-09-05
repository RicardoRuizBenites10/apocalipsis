Ext.define('GrupoBruce.store.TipoTrabajador',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.TipoTrabajador',
    alias: 'store.StipoTrabajador',
    
    proxy: {
        type: 'ajax',
        api:{
            read: 'tipoTrabajadorBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

