Ext.define('GrupoBruce.view.regimenpensionario.RegimenPensionario',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.regimenpensionario.RegimenPensionarioController',
        'GrupoBruce.view.regimenpensionario.RegimenPensionarioModel',
        
        'GrupoBruce.view.regimenpensionario.ListRegimenPensionario',
        'GrupoBruce.view.regimenpensionario.FormRegimenPensionario'
    ],

    controller: 'Cregimenpensionario',
    viewModel: {
        type: 'VMregimenpensionario'
    },

    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistRegimenPensionario',
            id: 'id_wregimenpensionario',
            height: 500
    }]
});
