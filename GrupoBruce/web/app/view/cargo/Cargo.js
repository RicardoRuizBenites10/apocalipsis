Ext.define('GrupoBruce.view.cargo.Cargo', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.cargo.CargoController',
        'GrupoBruce.view.cargo.CargoModel',

        'GrupoBruce.view.cargo.FormCargo',
        'GrupoBruce.view.cargo.ListCargo'
    ],

    controller: 'Ccargo',
    viewModel: {
        type: 'VMcargo'
    },

    closable: true,
    resizable: false,
    modal: true,
    autoShow: true,
    height: 400,
    width: 620,

    bind: {
        title: '{title}'
    },

    items: [{
            xtype: 'WlistCargo',
            height: 355
        }]
});
