Ext.define('GrupoBruce.store.PlanillaTareo', {
    extend: 'Ext.data.Store',
    alias: 'store.SplanillaTareo',
    model: 'GrupoBruce.model.PlanillaTareo',

    remoteSort: true,
    remoteFilter: true,

    sorters: [{
            property: '-TRABAJADOR',
            direction: 'ASC'
        }]
});