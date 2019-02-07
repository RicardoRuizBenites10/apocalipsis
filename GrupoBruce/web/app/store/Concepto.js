Ext.define('GrupoBruce.store.Concepto', {
    extend: 'Ext.data.Store',
    alias: 'store.Sconcepto',
    model: 'GrupoBruce.model.Concepto',

    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: '-TCONCEPTO',
            direction: 'ASC'
        },{
            property: '-TVARIABLE',
            direction: 'ASC'
        },{
            property: 'ID_CONCEPTO',
            direction: 'ASC'
        }]
});