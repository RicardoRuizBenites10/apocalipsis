Ext.define('GrupoBruce.store.Actividad', {
    extend: 'Ext.data.Store',
    alias: 'store.Sactividad',
    model: 'GrupoBruce.model.Actividad',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: 'NOMBRE',
            direction: 'ASC'
        }]
});