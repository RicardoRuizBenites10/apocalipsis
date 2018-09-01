Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',

    alias: 'store.Strabajador',

    model: 'GrupoBruce.model.Trabajador',

    pageSize: 15,
    proxy: {
        type: 'ajax',
        api: {
            read: 'trabajadores',
            create: 'insert',
            update: 'update',
            destroy: 'delete'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        },
        simpleSortMode: false
    },

    autoLoad: true,
    remoteSort: true,
    remoteFilter: true

    , sorters: [
        {property: 'idTrabajador', direction: 'ASC'}
    ]


});