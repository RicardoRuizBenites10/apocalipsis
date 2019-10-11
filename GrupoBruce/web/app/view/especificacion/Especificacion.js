Ext.define('GrupoBruce.view.especificacion.Especificacion', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.especificacion.EspecificacionController',
        'GrupoBruce.view.especificacion.EspecificacionModel',
        
        'GrupoBruce.view.especificacion.ListEspecificacion',
        'GrupoBruce.view.especificacion.FormEspecificacion'
    ],

    controller: 'Cespecificacion',
    viewModel: {
        type: 'VMespecificacion'
    },

    title: 'Lista de especificaciones',
    items: [{
            xtype: 'Wlistespecificacion',
            height: 500
        }]
});
