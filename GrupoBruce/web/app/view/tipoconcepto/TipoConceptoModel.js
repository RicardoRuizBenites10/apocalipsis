Ext.define('GrupoBruce.view.tipoconcepto.TipoConceptoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtipoconcepto',
    data: {
        selectTipoConcepto: null
    },
    
    stores: {
        tiposConcepto: {
            type: 'StipoConcepto',
            autoLoad: true
        }
    }

});
