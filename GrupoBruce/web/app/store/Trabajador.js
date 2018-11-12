Ext.define('GrupoBruce.store.Trabajador', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Trabajador',
    alias: 'store.Strabajador',

    remoteSort: true,
    remoteFilter: true,
    
    sorters: [
        {property: 'idTrabajador', direction: 'ASC'}
    ]

});