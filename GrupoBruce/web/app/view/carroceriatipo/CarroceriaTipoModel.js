Ext.define('GrupoBruce.view.carroceriatipo.CarroceriaTipoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcarroceriatipo',
    data: {
        newRegister: true,
        recordCarroceriaModelo: null
    },

    stores: {
        carroceriatipos: {
            type: 'Scarroceriatipo',
            autoLoad: true,
            filters: [{
                    property: 'ID_CARMOD',
                    value: '{recordCarroceriaModelo.idCarmod}'
                }]
        }
    }

});
