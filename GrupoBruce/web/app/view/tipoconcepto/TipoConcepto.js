Ext.define('GrupoBruce.view.tipoconcepto.TipoConcepto', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.tipoconcepto.TipoConceptoController',
        'GrupoBruce.view.tipoconcepto.TipoConceptoModel',

        'GrupoBruce.view.tipoconcepto.FormTipoConcepto',
        'GrupoBruce.view.tipoconcepto.ListTipoConcepto'
    ],

    controller: 'Ctipoconcepto',
    viewModel: {
        type: 'VMtipoconcepto'
    },

    title: 'Lista de tipos de concepto',
    items: [{
            xtype: 'WlistTipoConcepto',
            height: 500
        }]
});
