Ext.define('GrupoBruce.store.Proforma', {
    extend: 'Ext.data.Store',
    alias: 'store.Sproforma',
    model: 'GrupoBruce.model.Proforma',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: 'FECHA',
            direction: 'DESC'
        }]
});