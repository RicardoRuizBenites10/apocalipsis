Ext.define('GrupoBruce.store.Carroceria', {
    extend: 'Ext.data.Store',
    alias: 'store.Scarroceria',
    model: 'GrupoBruce.model.Carroceria',

    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'CODIGO',
            direction: 'ASC'
        }]
});