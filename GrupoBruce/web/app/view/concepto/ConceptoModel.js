Ext.define('GrupoBruce.view.concepto.ConceptoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMconcepto',
    data: {
        selectConcepto: null,
        selectTipoTrabajador: null,
        newItem: false
    },

    stores: {
        conceptos: {
            type: 'Sconcepto',
            autoLoad: true,
            filters: [{
                    property: 'ID_TTRABAJADOR',
                    operator: 'EQ',
                    value: '{selectTipoTrabajador.idTtrabajador}'
                }]
        },
        tiposConcepto: {
            type: 'StipoConcepto',
            autoLoad: true
        },
        tiposVariable: {
            type: 'StipoVariable',
            autoLoad: true
        },
        tiposTrabajador: {
            type: 'StipoTrabajador',
            autoLoad: true
        }
    },
    
    formulas: {
        allowNuevo : function(get){
            var selecttt = get('selectTipoTrabajador');
            return selecttt ?  get('selectConcepto') : !selecttt;
        }
    }

});
