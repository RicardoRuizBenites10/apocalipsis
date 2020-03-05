Ext.define('GrupoBruce.store.RequerimientoActividad',{
    extend: 'Ext.data.Store',
    alias: 'store.Srequerimientoactividad',
    model: 'GrupoBruce.model.RequerimientoActividad',
    
    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-ACTIVIDAD',
            direction: 'ASC'
        }]
});