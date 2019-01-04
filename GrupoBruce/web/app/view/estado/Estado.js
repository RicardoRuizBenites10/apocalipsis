Ext.define('GrupoBruce.view.estado.Estado',{
    extend: 'Ext.window.Window',
    alias: 'Westado',

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
            id: 'id_westado',
            height: 400,
            width: 600
        }]
});
