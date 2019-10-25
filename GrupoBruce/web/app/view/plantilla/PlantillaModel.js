Ext.define('GrupoBruce.view.plantilla.PlantillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMplantilla',
    data: {
        categorias: null
    },

    stores: {
        especificacions: {
            type: 'Sespecificacion',
            proxy: {
                type: 'ajax',
                url: 'especificacionSelects',
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                    totalProperty: 'total'
                },
                writer: {
                    type: 'json',
                    writeAllFields: true
                }
            },
            filters: [{
                    property: 'IDCARROCERIA',
                    operator: 'eq',
                    value: '{recordCarroceria.idCarroceria}',
                    inWhere: false
                }, {
                    property: 'ID_ECATEGORIA',
                    operator: 'in',
                    value: '{categorias}'
                }],
            autoLoad: true
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
