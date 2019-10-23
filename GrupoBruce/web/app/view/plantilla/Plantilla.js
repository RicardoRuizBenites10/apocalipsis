
Ext.define('GrupoBruce.view.plantilla.Plantilla',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.plantilla.PlantillaController',
        'GrupoBruce.view.plantilla.PlantillaModel'
    ],

    controller: 'plantilla-plantilla',
    viewModel: {
        type: 'plantilla-plantilla'
    },

    html: 'Hello, World!!'
});
