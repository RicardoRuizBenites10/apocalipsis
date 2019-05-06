Ext.define('GrupoBruce.store.Obra', {
    extend: 'Ext.data.Store',
    alias: 'store.Sobra',
    model: 'GrupoBruce.model.Obra',

    remoteSort: true,
    remoteFilter: true,
    sorters: [{
            property: 'NOMBRE',
            direction: 'ASC'
        }]
});