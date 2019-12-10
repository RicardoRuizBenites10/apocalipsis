Ext.define('GrupoBruce.view.obracontratista.ObraContratistaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobracontratista',

    data: {
        recordObra: null,
        selectObraContratista: null
    },

    stores: {
        obracontratistas: {
            type: 'Sobracontratista',
            autoLoad: true,
            filters: [{
                    property: 'ID_OBRA',
                    operator: 'eq',
                    value: '{recordObra.idObra}'
                }]
        },
        contratistas: {
            type: 'Scontratista',
            autoLoad: true
        },
        etapaprocesos: {
            type: 'Setapaproceso',
            autoLoad: true
        }
    }

});
