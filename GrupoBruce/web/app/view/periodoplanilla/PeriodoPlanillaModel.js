Ext.define('GrupoBruce.view.periodoplanilla.PeriodoPlanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMperiodoplanilla',
    data: {
        selectPeriodoPlanilla: null
    },
    
    stores: {
        periodosPlanilla: {
            type: 'SperiodoPlanilla',
            autoLoad: true
        },
        tiposTrabajador: {
            type: 'StipoTrabajador',
            autoLoad: true
        }
    }

});
