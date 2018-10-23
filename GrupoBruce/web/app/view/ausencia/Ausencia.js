Ext.define('GrupoBruce.view.ausencia.Ausencia',{
    extend: 'Ext.window.Window',
    reference: 'panel_ausencia',

    requires: [
        'GrupoBruce.view.ausencia.AusenciaController',
        'GrupoBruce.view.ausencia.AusenciaModel',
        
        'GrupoBruce.view.ausencia.ListAusencia',
        'GrupoBruce.view.ausencia.FormAusencia'
    ],

    controller: 'Causencia',
    viewModel: {
        type: 'VMausencia'
    },

    height: 400,
    width: 700,
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,
    bind: {
        title: '{title}'
    },
    
    items: [{
            xtype: 'WlistAusencia',
            height: 355
    }]
});
