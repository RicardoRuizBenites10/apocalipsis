Ext.define('GrupoBruce.view.actividad.Actividad', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.actividad.ActividadController',
        'GrupoBruce.view.actividad.ActividadModel',
        'GrupoBruce.view.actividad.FormActividad',
        'GrupoBruce.view.actividad.ListActividad'
    ],

    controller: 'Cactividad',
    viewModel: {
        type: 'VMactividad'
    },

    title: 'Lista de actividades',
    items: [{
            xtype: 'WlistActividad',
            height: 500
        }]
});
