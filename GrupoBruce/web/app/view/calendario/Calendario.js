Ext.define('GrupoBruce.view.calendario.Calendario', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.calendario.CalendarioController',
        'GrupoBruce.view.calendario.CalendarioModel',

        'GrupoBruce.view.calendario.FormCalendario',
        'GrupoBruce.view.calendario.ListCalendario'
    ],

    controller: 'Ccalendario',
    viewModel: {
        type: 'VMcalendario'
    },
    
    title: 'Calendario laboral',
    items: [{
            xtype: 'WlistCalendario',
            height: 500
        }]
});
