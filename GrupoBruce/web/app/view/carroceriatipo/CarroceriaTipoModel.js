Ext.define('GrupoBruce.view.carroceriatipo.CarroceriaTipoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcarroceriatipo',
    data: {
        newRegister: true,
        recordCarroceriaModelo: null
    },
    
    stores: {
        carroceriatipos: {
            type: 'ScarroceriaTipo',
            autoLoad: true
        }
    }

});
