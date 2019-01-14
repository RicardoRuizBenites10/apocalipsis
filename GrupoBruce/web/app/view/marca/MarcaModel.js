Ext.define('GrupoBruce.view.marca.MarcaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmarca',
    data: {
        title: 'Lista de marcas',
        nameFile: null
    },

    stores: {
        importacions: {
            type: 'Smarca',
            proxy: {
                type: 'ajax',
                url: 'imports',
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
                    property: 'nameFile',
                    value: '{nameFile}'
                }]
        },
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true,
            sorters: [
                {property: 'apPaterno', direction: 'ASC'},
                {property: 'apMaterno', direction: 'ASC'},
                {property: 'nombres', direction: 'ASC'}
            ],
            listeners: {
                beforeload: function (store) {
                    var query = Ext.getCmp('id_trabajadorMarca');
                    var valor = query !== undefined ? query.getValue() : 'x1';
                    store.getProxy().setExtraParam("query", valor);
                }
            }
        }
    }

});
