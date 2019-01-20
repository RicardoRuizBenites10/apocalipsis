Ext.define('GrupoBruce.view.conceptoasignado.ConceptoAsignado', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.conceptoasignado.ConceptoAsignadoController',
        'GrupoBruce.view.conceptoasignado.ConceptoAsignadoModel',

        'GrupoBruce.view.conceptoasignado.ListConceptoAsignado'
    ],

    controller: 'Cconceptoasignado',
    viewModel: {
        type: 'VMconceptoasignado'
    },

    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,

    title: 'Lista de conceptos asignados',
    items: [{
            xtype: 'WlistConceptoAsignado',
            width: 600,
            height: 400
        }]
});
