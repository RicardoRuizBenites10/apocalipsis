Ext.define('GrupoBruce.view.unidadmedida.UnidadMedida', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.unidadmedida.UnidadMedidaController',
        'GrupoBruce.view.unidadmedida.UnidadMedidaModel',

        'GrupoBruce.view.unidadmedida.ListUnidadMedida',
        'GrupoBruce.view.unidadmedida.FormUnidadMedida'
    ],

    controller: 'Cunidadmedida',
    viewModel: {
        type: 'VMunidadmedida'
    },

    bind: {
        title: '{titulo}'
    },

    items: [{
            xtype: 'Wlistunidadmedida',
            height: 500
        }]
});
