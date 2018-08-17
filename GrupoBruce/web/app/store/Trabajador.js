Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',

    alias: 'store.Strabajador',

    model: 'GrupoBruce.model.EstadoTrabajador',

    autoLoad: false,
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
        },
        pageParam: 'pagina',
        startParam: 'inicio',
        limitParam: 'limite',
        sortParam: 'orden',

        extraParams: {
            buscador1: 'value1',
            buscador2: 'value2'
        }
    },

    listeners: {
        beforeload: function (store, operation, eOpts) {
            var filterText = 10; //Ext.getCmp('filterText').value;
            store.getProxy().setExtraParam("paramBeforeLoad", filterText);
        }
    }

//    ,sorters: [
//        {property: 'idTrabajador', direction: 'ASC'}
//    ]

});