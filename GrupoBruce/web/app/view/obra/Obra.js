Ext.define('GrupoBruce.view.obra.Obra', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.obra.ObraController',
        'GrupoBruce.view.obra.ObraModel',
        
        'GrupoBruce.view.obra.ListObra',
        'GrupoBruce.view.obra.FormObra'
    ],

    controller: 'Cobra',
    viewModel: {
        type: 'VMobra'
    },

    title: 'Lista de ordenes de producción',
    items: [{
            xtype: 'Wlistobra',
            height: 500
        }]
});
