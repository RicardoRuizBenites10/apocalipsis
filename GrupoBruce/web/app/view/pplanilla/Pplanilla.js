
Ext.define('GrupoBruce.view.pplanilla.Pplanilla',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.pplanilla.PplanillaController',
        'GrupoBruce.view.pplanilla.PplanillaModel',
        
        'GrupoBruce.view.pplanilla.ListPplanilla'
    ],

    controller: 'Cpplanilla',
    viewModel: {
        type: 'VMpplanilla'
    },
    
    title: 'Planilla',
    items: [{
            xtype: 'WlistPplanilla',
            height: 500 
    }]
});
