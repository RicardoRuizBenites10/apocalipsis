Ext.define('GrupoBruce.view.carroceriatipo.CarroceriaTipo', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.carroceriatipo.CarroceriaTipoController',
        'GrupoBruce.view.carroceriatipo.CarroceriaTipoModel',

        'GrupoBruce.view.carroceriatipo.FormCarroceriaTipo',
        'GrupoBruce.view.carroceriatipo.ListCarroceriaTipo'
    ],

    controller: 'Ccarroceriatipo',
    viewModel: {
        type: 'VMcarroceriatipo'
    },

    modal: true,
    autoShow: true,
    title: 'Lista de subtipos de carroceria',

    items: [{
            xtype: 'Wlistcarroceriatipo',
            width: 600,
            height: 350
        }]
});
