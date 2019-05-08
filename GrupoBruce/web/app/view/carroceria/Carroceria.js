Ext.define('GrupoBruce.view.carroceria.Carroceria', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.carroceria.CarroceriaController',
        'GrupoBruce.view.carroceria.CarroceriaModel',

        'GrupoBruce.view.carroceria.FormCarroceria',
        'GrupoBruce.view.carroceria.ListCarroceria'
    ],

    controller: 'Ccarroceria',
    viewModel: {
        type: 'VMcarroceria'
    },

    items: [{
            xtype: 'Wlistcarroceria',
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
