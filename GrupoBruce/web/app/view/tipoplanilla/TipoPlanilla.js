Ext.define('GrupoBruce.view.tipoplanilla.TipoPlanilla',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.tipoplanilla.TipoPlanillaController',
        'GrupoBruce.view.tipoplanilla.TipoPlanillaModel',
        
        'GrupoBruce.view.tipoplanilla.FormTipoPlanilla',
        'GrupoBruce.view.tipoplanilla.ListTipoPlanilla'
    ],

    controller: 'Ctipoplanilla',
    viewModel: {
        type: 'VMtipoplanilla'
    },

    title: 'Lista de tipos de planilla',
    items: [{
            xtype: 'WlistTipoPlanilla',
            height: 500
    }]
});
