
Ext.define('GrupoBruce.view.entidadfinanciera.EntidadFinanciera', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.entidadfinanciera.EntidadFinancieraController',
        'GrupoBruce.view.entidadfinanciera.EntidadFinancieraModel',

        'GrupoBruce.view.entidadfinanciera.FormEntidadFinanciera',
        'GrupoBruce.view.entidadfinanciera.ListEntidadFinanciera'
    ],

    controller: 'Centidadfinanciera',
    viewModel: {
        type: 'VMentidadfinanciera'
    },

    html: 'Hello, World!!'
});
