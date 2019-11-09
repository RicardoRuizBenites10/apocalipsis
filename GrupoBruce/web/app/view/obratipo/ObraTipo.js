Ext.define('GrupoBruce.view.obratipo.ObraTipo',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.obratipo.ObraTipoController',
        'GrupoBruce.view.obratipo.ObraTipoModel',
        
        'GrupoBruce.view.obratipo.ListObraTipo',
        'GrupoBruce.view.obratipo.FormObraTipo'
    ],

    controller: 'Cobratipo',
    viewModel: {
        type: 'VMobratipo'
    },

    title: 'Lista de tipos de ordenes de producción',
    items: [{
            xtype: 'Wlistobratipo',
            height: 500
    }]
});
