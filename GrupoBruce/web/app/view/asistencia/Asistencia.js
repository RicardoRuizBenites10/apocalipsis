
Ext.define('GrupoBruce.view.asistencia.Asistencia',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.asistencia.AsistenciaController',
        'GrupoBruce.view.asistencia.AsistenciaModel'
    ],

    controller: 'asistencia-asistencia',
    viewModel: {
        type: 'asistencia-asistencia'
    },

    html: 'Hello, World!!'
});
