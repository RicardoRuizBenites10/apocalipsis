Ext.define('GrupoBruce.store.EspecificacionActividad',{
    extend: 'Ext.data.Store',
    alias: 'store.Sespecificacionactividad',
    model: 'GrupoBruce.model.EspecificacionActividad',
    
    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: '-ACTIVIDAD',
            direction: 'ASC'
    }]
});