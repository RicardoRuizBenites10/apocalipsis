Ext.define('GrupoBruce.view.cliente.Cliente', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.cliente.ClienteController',
        'GrupoBruce.view.cliente.ClienteModel',

        'GrupoBruce.view.cliente.ListCliente',
        'GrupoBruce.view.cliente.FormCliente'
    ],

    controller: 'Ccliente',
    viewModel: {
        type: 'VMcliente'
    },

    title: 'Lista de clientes',
    items: [{
            xtype: 'Wlistcliente',
            height: 500
        }]
});
