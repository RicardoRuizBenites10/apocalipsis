Ext.define('GrupoBruce.view.contratista.Contratista', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.contratista.ContratistaController',
        'GrupoBruce.view.contratista.ContratistaModel',

        'GrupoBruce.view.contratista.FormContratista',
        'GrupoBruce.view.contratista.ListContratista'
    ],

    controller: 'Ccontratista',
    viewModel: {
        type: 'VMcontratista'
    },

    bind: {
        title: '{titulo}'
    },
    items: [{
            xtype: 'Wlistcontratista',
            height: 500
        }]
});
