Ext.define('GrupoBruce.view.sucursal.Sucursal', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.sucursal.SucursalController',
        'GrupoBruce.view.sucursal.SucursalModel',

        'GrupoBruce.view.sucursal.FormSucursal',
        'GrupoBruce.view.sucursal.ListSucursal'
    ],

    controller: 'Csucursal',
    viewModel: {
        type: 'VMsucursal'
    },

    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,

    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistSucursal',
            id: 'id_wsucursal',
            height: 400,
            width: 600
        }]
});
