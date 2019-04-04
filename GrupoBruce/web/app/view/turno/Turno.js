Ext.define('GrupoBruce.view.turno.Turno',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.turno.TurnoController',
        'GrupoBruce.view.turno.TurnoModel',
        
        'GrupoBruce.view.turno.ListTurno',
        'GrupoBruce.view.turno.FormTurno'
    ],

    controller: 'Cturno',
    viewModel: {
        type: 'VMturno'
    },

    title: 'Lista de turnos',
    items: [{
            xtype: 'WlistTurno',
            height: 500
    }]
});
