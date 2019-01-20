Ext.define('GrupoBruce.view.conceptoasignado.ConceptoAsignadoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMconceptoasignado',
    
    data: {
        recordTipoTrabajador: null,
        selectConceptoAsignado: null
    },

    stores: {
        conceptos: {
            type: 'Sconcepto',
            autoLoad: true
        },
        conceptosAsignado: {
            type: 'SconceptoAsignado',
            autoLoad: true,
            filters: [{
                    property: 'idTtrabajador',
                    operator: 'eq',
                    value: '{recordTipoTrabajador.idTtrabajador}'
                }]
        }
    }

});
