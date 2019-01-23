Ext.define('GrupoBruce.view.almuerzo.AlmuerzoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMalmuerzo',
    
    data: {
        selectAlmuerzo: null,
        desde: new Date()
    },
    
    stores: {
        almuerzos: {
            type: 'Salmuerzo',
            autoLoad: true,
            filters: [{
                    property: 'FECHA',
                    operator: 'fecha',
                    value: '{desde}'
            }]
        }
    }

});
