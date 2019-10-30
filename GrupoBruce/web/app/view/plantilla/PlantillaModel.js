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
                    property: 'PT.ID_CARROCERIA',
                    operator: 'eq',
                    value: '{recordCarroceria.idCarroceria}',
                    inWhere: false
                }, {
                    property: 'ID_ECATEGORIA',
                    operator: 'in',
                    value: '{categorias}'
                }],
            listeners: {
                load: function (store, records, successful, operation, eOpts) {
                    var grid = Ext.getCmp('id_gridesp'), selections = [];
                    selections = records.filter(item => item.get('asignado'));
                    if (grid !== undefined) {
                        grid.getSelectionModel().select(selections);
                    }
                }
            }
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
                }, {
                    property: 'EC.ID_ECATEGORIA',
                    operator: 'in',
                    value: '{categorias}'
                }]
        }
    }

});
