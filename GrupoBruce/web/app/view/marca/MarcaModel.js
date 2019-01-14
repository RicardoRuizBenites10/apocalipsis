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
        }
    }

});
