Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',
    
    alias: 'store.Strabajador',

    model: 'GrupoBruce.model.EstadoTrabajador',
    
    autoLoad: true,
    pageSize: 15,
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'trabajadores'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        }
    },
    
    sorters: [
        {property: 'idTrabajador', direction: 'ASC'}
    ]

});