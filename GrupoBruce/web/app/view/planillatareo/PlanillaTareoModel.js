Ext.define('GrupoBruce.view.planillatareo.PlanillaTareoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMplanillatareo',
    data: {
        selectPlanillaTareo: null,
        selectTipoTrabajador: null,
        selectPeriodoPlanilla: null
    },

    stores: {
        tiposTrabajador: {
            type: 'StipoTrabajador',
            autoLoad: true
        },
        periodosPlanilla: {
            type: 'SperiodoPlanilla',
            autoLoad: true,
            filters: [{
                    property: 'idTtrabajador',
                    operator: 'EQ',
                    value: '{selectTipoTrabajador.idTtrabajador}'
                }]
        },
        planillasTareo: {
            type: 'SplanillaTareo',
            autoLoad: true,
            filters: [{
                    property: 'PP.ID_PPLANILLA',
                    operator: 'EQ',
                    value: '{selectPeriodoPlanilla.idPplanilla}'
                }]
        }
    }

});
