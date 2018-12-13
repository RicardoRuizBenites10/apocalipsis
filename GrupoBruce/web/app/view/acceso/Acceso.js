Ext.define('GrupoBruce.view.acceso.Acceso',{
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.acceso.AccesoController',
        'GrupoBruce.view.acceso.AccesoModel',
        
        'GrupoBruce.view.acceso.ListAcceso'
    ],

    controller: 'Cacceso',
    viewModel: {
        type: 'VMacceso'
    },

    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,

    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistAcceso',
            height: 400,
            width: 600
    }]
});
