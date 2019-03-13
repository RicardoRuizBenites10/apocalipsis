Ext.define('GrupoBruce.view.almuerzo.AlmuerzoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMalmuerzo',

    data: {
        selectAlmuerzo: null,
        desde: new Date(),
        pageSize: null,
        allRecord: false
    },

    stores: {
        almuerzos: {
            type: 'Salmuerzo',
            loading: true,
            autoLoad: true,
            pageSize: '{pageSize ? pageSize : 25}',
            filters: [{
                    property: 'FECHA',
                    operator: 'fecha',
                    value: '{desde}'
                }]
        },
        empresas: {
            type: 'Sempresa',
            autoLoad: true
        }
    },
    
    formulas: {
        allowEdit: function(get){
            var selection = get('selectAlmuerzo');
            var allow = selection ? selection.get('procesado') : !selection;
            return allow;
        },
        allRecord: function(get){
            var almuerzos = get('almuerzos');
            return almuerzos.totalCount > 0;
        }
    }

});
