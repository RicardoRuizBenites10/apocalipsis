Ext.define('GrupoBruce.view.carroceriatipo.CarroceriaTipo',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.carroceriatipo.CarroceriaTipoController',
        'GrupoBruce.view.carroceriatipo.CarroceriaTipoModel'
    ],

    controller: 'Ccarroceriatipo',
    viewModel: {
        type: 'VMcarroceriatipo'
    },

    html: 'Hello, World!!'
});
