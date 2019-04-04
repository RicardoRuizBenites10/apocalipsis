Ext.define('GrupoBruce.view.horario.Horario', {
    extend: 'Ext.window.Window',

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
    
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,

    title: 'Horario laboral',
    items: [{
            xtype: 'WlistHorario',
            height: 400,
            width: 600
        }]
});
