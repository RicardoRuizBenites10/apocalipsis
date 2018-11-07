
Ext.define('GrupoBruce.view.equipo.Equipo',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.equipo.EquipoController',
        'GrupoBruce.view.equipo.EquipoModel'
    ],

    controller: 'Cequipo',
    viewModel: {
        type: 'VMequipo'
    },

    html: 'Hello, World!!'
});
