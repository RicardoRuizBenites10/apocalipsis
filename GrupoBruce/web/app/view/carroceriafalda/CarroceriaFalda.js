Ext.define('GrupoBruce.view.carroceriafalda.CarroceriaFalda', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.carroceriafalda.CarroceriaFaldaController',
        'GrupoBruce.view.carroceriafalda.CarroceriaFaldaModel',

        'GrupoBruce.view.carroceriafalda.ListCarroceriaFalda',
        'GrupoBruce.view.carroceriafalda.FormCarroceriaFalda'
    ],

    controller: 'Ccarroceriafalda',
    viewModel: {
        type: 'VMcarroceriafalda'
    },

    items: [{
            xtype: 'Wlistcarroceriafalda',
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
