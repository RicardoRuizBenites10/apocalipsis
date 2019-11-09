Ext.define('GrupoBruce.view.contratista.ContratistaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcontratista',
    data: {
        currentCodigo: null
    },

    stores: {
        contratistas: {
            type: 'Scontratista',
            autoLoad: true
        },
        etapasproceso: {
            type: 'Setapaproceso',
            autoLoad: true
        },
        currentContratista: {
            type: 'Scontratista',
            autoLoad: true,
            filters: [{
                    property: 'ID_CONTRATISTA',
                    operator: 'eq',
                    value: '{currentCodigo}'
                }]
        }
    }

});
