
Ext.define('GrupoBruce.view.horario.Horario', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.horario.HorarioController',
        'GrupoBruce.view.horario.HorarioModel',

        'GrupoBruce.view.horario.FormHorario',
        'GrupoBruce.view.horario.ListHorario'
    ],

    controller: 'Chorario',
    viewModel: {
        type: 'VMhorario'
    },

    title: 'Horario laboral',
    items: [{
            xtype: 'WlistHorario',
            height: 500
        }]
});
