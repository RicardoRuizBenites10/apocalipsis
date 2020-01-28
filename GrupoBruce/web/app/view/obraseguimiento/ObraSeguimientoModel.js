Ext.define('GrupoBruce.view.obraseguimiento.ObraSeguimientoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobraseguimiento',
    data: {
        name: 'GrupoBruce',
        recordObra: null
    },
    
    stores: {
        estadoobras: {
            type: 'Sestadoobra',
            autoLoad: true
        },
        obraseguimientos: {
            type: 'Sobraseguimiento',
            autoLoad: true,
            filters: [{
                    property: 'ID_OBRA',
                    operator: 'eq',
                    inWhere: false,
                    value: '{recordObra.idObra}'
            },{
                property: 'EP.PASA_BUS',
                operator: 'eq',
                value: 1
            }]
        }
    }

});
