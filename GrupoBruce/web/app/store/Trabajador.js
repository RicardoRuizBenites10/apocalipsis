Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Trabajador',
    alias: 'store.Strabajador',


    pageSize: 15,
    //Este proxy reescribe al del modelo
//    proxy: {
//        type: 'ajax',
//        api: {
//            read: 'trabajadores'
//        },
//        reader: {
//            type: 'json',
//            rootProperty: 'data',
//            totalProperty: 'total'
//        }
//    },

    autoLoad: true,
    remoteSort: true,
    remoteFilter: true

    , sorters: [
        {property: 'idTrabajador', direction: 'ASC'}
    ]


});