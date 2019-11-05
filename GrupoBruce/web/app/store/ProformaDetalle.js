Ext.define('GrupoBruce.store.ProformaDetalle', {
    extend: 'Ext.data.Store',
    alias: 'store.Sproformadetalle',
    model: 'GrupoBruce.model.ProformaDetalle',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: '-ESPECIFICACION',
            direction: 'ASC'
        }]
});