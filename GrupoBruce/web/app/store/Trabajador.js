Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Trabajador',
    alias: 'store.Strabajador',


    pageSize: 15,
    proxy: {
        type: 'ajax',
        api: {
            read: 'trabajadores',
            create: 'insertTrabajador',
            update: 'updateTrabajador',
            destroy: 'deleteTrabajador'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        }
    },

    autoLoad: true,
    remoteSort: true,
    remoteFilter: true

    , sorters: [
        {property: 'idTrabajador', direction: 'ASC'}
    ]


});