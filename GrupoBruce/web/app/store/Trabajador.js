Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',
    
    alias: 'store.Strabajador',

    model: 'GrupoBruce.model.Trabajador',
    
    autoLoad: true,
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'trabajadores'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    },
    
    sorters: [
        {property: 'idTrabajador', direction: 'ASC'}
    ]

});