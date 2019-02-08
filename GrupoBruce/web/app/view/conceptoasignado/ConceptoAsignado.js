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

    defaults: {
        height: 400,
        flex: 1
    },
    width: 800,
    layout: 'hbox',
    
    title: 'Lista de conceptos asignados',
    items: [{
            xtype: 'WlistConceptoAsignado'
        }, {
            xtype: 'WlistConcepto',
            tbar: [{
                    iconCls: 'x-fa fa-chevron-left',
                    text: 'ASIGNAR',
                    bind: {
                        disabled: '{allowAsignar}'
                    },
                    handler: 'onAsignar'
                }]
        }]
});
