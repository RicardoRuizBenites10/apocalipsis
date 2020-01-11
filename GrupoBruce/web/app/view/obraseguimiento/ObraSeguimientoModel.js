Ext.define('GrupoBruce.view.obraseguimiento.ObraSeguimientoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMobraseguimiento',
    data: {
        name: 'GrupoBruce',
        recordObra: null
    },
    
    stores: {
        obraseguimientos: {
            type: 'Sobraseguimiento',
            autoload: true,
            filters: [{
                    property: 'ID_OBRA',
                    operatos: 'eq',
                    value: '{recordObra.idObra}'
            }]
        }
    }

});
