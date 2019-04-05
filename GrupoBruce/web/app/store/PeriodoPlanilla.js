Ext.define('GrupoBruce.store.PeriodoPlanilla', {
    extend: 'Ext.data.Store',
    alias: 'store.SperiodoPlanilla',
    model: 'GrupoBruce.model.PeriodoPlanilla',

    remoteSort: true,
    remoteFilter: true,
    
    sorters: [{
            property: 'inicio',
            direction: 'DESC'
        }]
});