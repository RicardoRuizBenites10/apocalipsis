Ext.define('GrupoBruce.view.periodoplanilla.PeriodoPlanilla',{
    extend: 'Ext.window.Window',

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
    
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,
    
    title: 'Lista de periodos de planilla',
    items: [{
            xtype: 'WlistPeriodoPlanilla',
            width: 600,
            height: 400
    }]
});
