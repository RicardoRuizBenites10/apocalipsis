Ext.define('GrupoBruce.view.proformadetalle.ProformaDetalleModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMproformadetalle',
    data: {
        recordProforma: null,
        recordCarroceria: null,
        selectProformaDetalle: null
    },

    stores: {
        categorias: {
            type: 'Sespecificacioncategoria',
            autoLoad: true
        },
        especificacions: {
            type: 'Sespecificacion',
            filters: [{
                    property: 'ID_ECATEGORIA',
                    operator: 'EQ',
                    value: '{selectCategoria.idEcategoria}'
                }, {
                    property: 'ID_ESPECIFICACION',
                    operator: 'nin',
                    value: ''
                }],
            listeners: {
                beforeload: function (store) {
                    var filter = store.getFilters().getAt(1);
                    var list = Ext.getCmp('id_wproformadetalle').getStore().collect('idEspecificacion');
                    filter.setValue(list.toString());
                }
            }
        },
        proformadetalles: {
            type: 'Sproformadetalle',
            autoLoad: true,
            filters: [{
                    property: 'PF.ID_CARROCERIA',
                    operator: 'eq',
                    value: '{recordCarroceria.idCarroceria}',
                    inWhere: false
                }]
        }
    }

});
