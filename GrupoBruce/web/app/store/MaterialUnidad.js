Ext.define('GrupoBruce.store.MaterialUnidad', {
    extend: 'Ext.data.Store',
    alias: 'store.Smaterialunidad',
    model: 'GrupoBruce.model.MaterialUnidad',

    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'BASE',
            direction: 'DESC'
        },{
            property: '-DENOMINACION',
            direction: 'ASC'
        }]
});