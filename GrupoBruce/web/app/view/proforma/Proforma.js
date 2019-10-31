Ext.define('GrupoBruce.view.proforma.Proforma', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.proforma.ProformaController',
        'GrupoBruce.view.proforma.ProformaModel',

        'GrupoBruce.view.proforma.ListProforma',
        'GrupoBruce.view.proforma.FormProforma'
    ],

    controller: 'Cproforma',
    viewModel: {
        type: 'VMproforma'
    },

    title: 'Lista de proformas de clientes',
    items: [{
            xtype: 'Wlistproforma',
            height: 500
        }]
});
