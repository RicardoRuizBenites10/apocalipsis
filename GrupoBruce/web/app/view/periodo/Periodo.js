
Ext.define('GrupoBruce.view.periodo.Periodo',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.periodo.PeriodoController',
        'GrupoBruce.view.periodo.PeriodoModel'
    ],

    controller: 'periodo-periodo',
    viewModel: {
        type: 'periodo-periodo'
    },

    html: 'Hello, World!!'
});
