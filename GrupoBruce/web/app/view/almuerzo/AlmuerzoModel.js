Ext.define('GrupoBruce.view.almuerzo.AlmuerzoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMalmuerzo',

    data: {
        selectAlmuerzo: null,
        desde: new Date(),
        pageSize: null
    },

    stores: {
        almuerzos: {
            type: 'Salmuerzo',
            autoLoad: true,
            pageSize: '{pageSize ? pageSize : 25}',
            filters: [{
                    property: 'FECHA',
                    operator: 'fecha',
                    value: '{desde}'
                }]
        }
    }

});
