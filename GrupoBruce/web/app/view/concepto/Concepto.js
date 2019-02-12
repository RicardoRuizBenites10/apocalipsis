
Ext.define('GrupoBruce.view.concepto.Concepto', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.concepto.ConceptoController',
        'GrupoBruce.view.concepto.ConceptoModel',
        'GrupoBruce.view.concepto.ListConcepto',
        'GrupoBruce.view.concepto.FormConcepto'
    ],

    controller: 'Cconcepto',
    viewModel: {
        type: 'VMconcepto'
    },

    title: 'Lista de conceptos',
    items: [{
            xtype: 'WlistConcepto',
            id: 'id_wlistconcepto',
            height: 500
        }]
});
