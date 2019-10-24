Ext.define('GrupoBruce.view.especificacion.EspecificacionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMespecificacion',

    data: {
        categorias: null
    },

    stores: {
        especificacions: {
            type: 'Sespecificacion',
            autoLoad: true,
            filters: [{
                    property: 'ID_ECATEGORIA',
                    operator: 'in',
                    value: '{categorias}'
            }]
        },
        especificacioncategorias: {
            type: 'Sespecificacioncategoria',
            autoLoad: true
        }
    }

});
