Ext.define('GrupoBruce.view.periodoplanilla.PeriodoPlanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMperiodoplanilla',
    data: {
        selectPeriodoPlanilla: null,
        selectSearchTTrabajador: null
    },
    
    stores: {
        periodosPlanilla: {
            type: 'SperiodoPlanilla',
            autoLoad: true,
            filters:[{
                    property: 'idTtrabajador',
                    operator: 'eq',
                    value: '{selectSearchTTrabajador.idTtrabajador}'
            }]
        },
        tiposTrabajador: {
            type: 'StipoTrabajador',
            autoLoad: true
        }
    }

});
