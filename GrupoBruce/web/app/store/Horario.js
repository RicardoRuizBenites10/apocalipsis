Ext.define('GrupoBruce.store.Horario', {
    extend: 'Ext.data.Store',
    alias: 'store.Shorario',
    model: 'GrupoBruce.model.Horario',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: 'ID_DIA',
            direction: 'ASC'
        }]
});