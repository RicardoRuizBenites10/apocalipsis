Ext.define('GrupoBruce.view.periodoplanilla.PeriodoPlanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMperiodoplanilla',
    data: {
        recordTipoTrabajador: null,
        selectPeriodoPlanilla: null
    },
    
    stores: {
        periodosPlanilla: {
            type: 'SperiodoPlanilla',
            autoLoad: true,
            filters:[{
                    property: 'idTtrabajador',
                    operator: 'eq',
                    value: '{recordTipoTrabajador.idTtrabajador}'
            }]
        }
    }

});
