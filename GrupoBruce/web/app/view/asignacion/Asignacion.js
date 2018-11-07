
Ext.define('GrupoBruce.view.asignacion.Asignacion',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.asignacion.AsignacionController',
        'GrupoBruce.view.asignacion.AsignacionModel'
    ],

    controller: 'Casignacion',
    viewModel: {
        type: 'VMasignacion'
    },

    html: 'Hello, World!!'
});
