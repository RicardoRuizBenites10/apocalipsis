Ext.define('GrupoBruce.view.carroceriamodelo.CarroceriaModelo', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.carroceriamodelo.CarroceriaModeloController',
        'GrupoBruce.view.carroceriamodelo.CarroceriaModeloModel',
        
        'GrupoBruce.view.carroceriamodelo.ListCarroceriaModelo',
        'GrupoBruce.view.carroceriamodelo.FormCarroceriaModelo'
    ],

    controller: 'Ccarroceriamodelo',
    viewModel: {
        type: 'VMcarroceriamodelo'
    },

    items: [{
            xtype: 'WlistCarroceriaModel',
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
