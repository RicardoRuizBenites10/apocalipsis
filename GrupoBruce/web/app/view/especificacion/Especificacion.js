Ext.define('GrupoBruce.view.especificacion.Especificacion', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.especificacion.EspecificaciónController',
        'GrupoBruce.view.especificacion.EspecificaciónModel'
    ],

    controller: 'Cespecificación',
    viewModel: {
        type: 'VMespecificación'
    },

    title: 'Lista de especificaciones',
    items: [{
            xtype: 'Wlistespecificacion',
            height: 500
        }]
});
