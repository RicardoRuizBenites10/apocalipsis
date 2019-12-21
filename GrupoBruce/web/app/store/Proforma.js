Ext.define('GrupoBruce.store.Proforma', {
    extend: 'Ext.data.Store',
    alias: 'store.Sproforma',
    model: 'GrupoBruce.model.Proforma',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: 'ID_PROFORMA',
            direction: 'ASC'
        }, {
            property: 'FECHA_UPDATE',
            direction: 'DESC'
        }]
});