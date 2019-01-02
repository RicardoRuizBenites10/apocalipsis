Ext.define('GrupoBruce.view.estado.Estado',{
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.estado.EstadoController',
        'GrupoBruce.view.estado.EstadoModel',
        
        'GrupoBruce.view.estado.ListEstado',
        'GrupoBruce.view.estado.FormEstado'
    ],

    controller: 'Cestado',
    viewModel: {
        type: 'VMestado'
    },

    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,

    bind: {
        title: '{title}'
    },

    items: [{
            xtype: 'WlistEstado',
            height: 400,
            width: 600
        }]
});
