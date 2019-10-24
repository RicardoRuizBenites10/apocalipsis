Ext.define('GrupoBruce.view.plantilla.PlantillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMplantilla',
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
        },
        carrocerias: {
            type: 'Scarroceria',
            autoLoad: true
        },
        plantillas: {
            type: 'Splantilla',
            autoLoad: true,
            filters: [{
                    property: 'ID_CARROCERIA',
                    operator: 'EQ',
                    value: '{recordCarroceria.idCarroceria}'
                }]
        }
    }

});
