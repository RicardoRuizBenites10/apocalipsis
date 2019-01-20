Ext.define('GrupoBruce.view.concepto.ConceptoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMconcepto',
    data: {
        selectConcepto: null
    },
    
    stores: {
        conceptos: {
            type: 'Sconcepto',
            autoLoad: true
        },
        tiposConcepto: {
            type: 'StipoConcepto',
            autoLoad: true
        },
        tiposVariable: {
            type: 'StipoVariable',
            autoLoad: true
        },
        tiposPlanilla: {
            type: 'StipoPlanilla',
            autoLoad: true
        }
    }

});
