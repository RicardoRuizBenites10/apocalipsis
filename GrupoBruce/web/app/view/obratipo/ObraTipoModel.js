Ext.define('GrupoBruce.view.obratipo.ObraTipoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobratipo',

    data: {
        selectObraTipo: null,
        currenCodigo: null
    },

    stores: {
        obratipos: {
            type: 'Sobratipo',
            autoLoad: true
        },
        currentObraTipo: {
            type: 'Sobratipo',
            filters: [{
                    property: 'idObrtip',
                    operator: 'eq',
                    value: '{currentCodigo}'
                }]
        }
    }

});
