Ext.define('GrupoBruce.store.Chasis', {
    extend: 'Ext.data.Store',
    alias: 'store.Schasis',
    model: 'GrupoBruce.model.Chasis',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: 'MODELO',
            direction: 'ASC'
        }]
});