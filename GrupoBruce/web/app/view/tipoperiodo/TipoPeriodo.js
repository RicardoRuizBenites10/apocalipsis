
Ext.define('GrupoBruce.view.tipoperiodo.TipoPeriodo',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.tipoperiodo.TipoPeriodoController',
        'GrupoBruce.view.tipoperiodo.TipoPeriodoModel'
    ],

    controller: 'tipoperiodo-tipoperiodo',
    viewModel: {
        type: 'tipoperiodo-tipoperiodo'
    },

    html: 'Hello, World!!'
});
