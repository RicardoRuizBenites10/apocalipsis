Ext.define('GrupoBruce.store.EspecificacionActividad',{
    extend: 'Ext.data.Store',
    alias: 'store.SespecificacionActividad',
    model: 'GrupoBruce.model.EspecifiacionActividad',
    
    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'ACTIVIDAD',
            direction: 'ASC'
    }]
});