Ext.define('GrupoBruce.store.ColorFormula', {
    extend: 'Ext.data.Store',
    alias: 'store.Scolorformula',
    model: 'GrupoBruce.model.ColorFormula',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: 'ID_CDISENO',
            direction: 'ASC'
        }]
});