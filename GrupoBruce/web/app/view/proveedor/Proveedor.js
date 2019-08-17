Ext.define('GrupoBruce.view.proveedor.Proveedor', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.Wproveedor',

    requires: [
        'GrupoBruce.view.proveedor.ProveedorController',
        'GrupoBruce.view.proveedor.ProveedorModel',

        'GrupoBruce.view.proveedor.FormProveedor',
        'GrupoBruce.view.proveedor.ListProveedor'
    ],

    controller: 'Cproveedor',
    viewModel: {
        type: 'VMproveedor'
    },

    bind: {
        title: '{titulo}'
    },
    items: [{
            xtype: 'Wlistproveedor',
            height: 500
        }]
});
