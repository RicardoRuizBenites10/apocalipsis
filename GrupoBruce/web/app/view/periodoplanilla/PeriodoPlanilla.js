Ext.define('GrupoBruce.view.periodoplanilla.PeriodoPlanilla',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.periodoplanilla.PeriodoPlanillaController',
        'GrupoBruce.view.periodoplanilla.PeriodoPlanillaModel',
        
        'GrupoBruce.view.periodoplanilla.ListPeriodoPlanilla',
        'GrupoBruce.view.periodoplanilla.FormPeriodoPlanilla'
    ],

    controller: 'Cperiodoplanilla',
    viewModel: {
        type: 'VMperiodoplanilla'
    },
    
    title: 'Lista de periodos de planilla',
    items: [{
            xtype: 'WlistPeriodoPlanilla',
            height: 500
    }]
});
