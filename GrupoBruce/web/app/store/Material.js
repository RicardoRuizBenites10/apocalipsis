Ext.define('GrupoBruce.store.Material', {
    extend: 'Ext.data.Store',
    alias: 'store.Smaterial',
    model: 'GrupoBruce.model.Material',

    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'NOMBRE',
            direction: 'ASC'
        }]
});