Ext.define('GrupoBruce.view.chasisproveedor.ChasisProveedor', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.chasisproveedor.ChasisProveedorController',
        'GrupoBruce.view.chasisproveedor.ChasisProveedorModel',

        'GrupoBruce.view.chasisproveedor.FormChasisProveedor',
        'GrupoBruce.view.chasisproveedor.ListChasisProveedor'
    ],

    controller: 'Cchasisproveedor',
    viewModel: {
        type: 'VMchasisproveedor'
    },

    items: [{
            xtype: 'Wlistchasisproveedor',
            plugins: 'responsive',
            responsiveConfig: {
                small: {
                    height: 300
                },
                medium: {
                    height: 540
                },
                large: {
                    height: 830
                }
            }
        }]
});
