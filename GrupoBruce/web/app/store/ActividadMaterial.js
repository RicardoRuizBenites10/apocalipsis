Ext.define('GrupoBruce.store.ActividadMaterial', {
    extend: 'Ext.data.Store',
    alias: 'store.SactividadMaterial',
    model: 'GrupoBruce.model.ActividadMaterial',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: 'MATERIAL',
            direction: 'ASC'
        }]
});