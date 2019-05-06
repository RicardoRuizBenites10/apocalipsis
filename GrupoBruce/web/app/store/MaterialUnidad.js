Ext.define('GrupoBruce.store.MaterialUnidad', {
    extend: 'Ext.data.Store',
    alias: 'store.SmaterialUnidad',
    model: 'GrupoBruce.model.MaterialUnidad',

    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'DENOMINACION',
            direction: 'ASC'
        }]
});