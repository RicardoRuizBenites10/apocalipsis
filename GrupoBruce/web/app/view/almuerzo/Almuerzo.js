Ext.define('GrupoBruce.view.almuerzo.Almuerzo', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.almuerzo.AlmuerzoController',
        'GrupoBruce.view.almuerzo.AlmuerzoModel',

        'GrupoBruce.view.almuerzo.ListAlmuerzo',
        'GrupoBruce.view.almuerzo.FormAlmuerzo'
    ],

    controller: 'Calmuerzo',
    viewModel: {
        type: 'VMalmuerzo'
    },

    title: 'Lista de almuerzos',
    items: [{
            xtype: 'WlistAlmuerzo',
            height: 500
        }]
});
