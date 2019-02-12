Ext.define('GrupoBruce.view.planillatareo.PlanillaTareo', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.planillatareo.PlanillaTareoController',
        'GrupoBruce.view.planillatareo.PlanillaTareoModel',
        
        'GrupoBruce.view.planillatareo.ListPlanillaTareo'
    ],

    controller: 'Cplanillatareo',
    viewModel: {
        type: 'VMplanillatareo'
    },

    title: 'Seguimiento planilla',
    items: [{
            xtype: 'WlistPlanillaTareo',
            height: 500
        }]
});
