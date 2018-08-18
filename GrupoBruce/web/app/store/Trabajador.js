Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',

    alias: 'store.Strabajador',

    model: 'GrupoBruce.model.EstadoTrabajador',

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
    
    autoLoad: true,
    remoteSort: true
    
//    ,listeners: {
//        beforeload: function (store, operation, eOpts) {
//            var filterText = 10; //Ext.getCmp('filterText').value;
//            store.getProxy().setExtraParam("paramBeforeLoad", filterText);
//        }
//    }
    
    ,sorters: [
        {property: 'idTrabajador', direction: 'ASC'}
    ]

});