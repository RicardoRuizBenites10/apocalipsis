Ext.define('GrupoBruce.view.requerimiento.Requerimiento', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.requerimiento.RequerimientoController',
        'GrupoBruce.view.requerimiento.RequerimientoModel',

        'GrupoBruce.view.requerimiento.ListObraRequerimiento'
    ],

    controller: 'Crequerimiento',
    viewModel: {
        type: 'VMrequerimiento'
    },

    title: 'Lista de ordenes de producción',
    items: [{
            xtype: 'Wlistobrarequerimiento',
            height: 500
        }]
});
