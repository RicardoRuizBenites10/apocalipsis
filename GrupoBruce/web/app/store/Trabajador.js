Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Trabajador',
    alias: 'store.Strabajador',


    pageSize: 15,
    remoteSort: true,
    remoteFilter: true,

    sorters: [
        {property: 'idTrabajador', direction: 'ASC'}
    ]

});