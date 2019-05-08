Ext.define('GrupoBruce.view.carroceriamodelo.CarroceriaModeloModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcarroceriamodelo',
    data: {
        newRegister: true
    },

    stores: {
        carroceriaModelos: {
            type: 'Scarroceriamodelo',
            autoLoad: true
        }
    }

});
