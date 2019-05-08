Ext.define('GrupoBruce.view.carroceriafalda.CarroceriaFaldaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMcarroceriafalda',
    data: {
        name: 'GrupoBruce'
    },
    
    stores: {
        carroceriafaldas: {
            type: 'Scarroceriafalda',
            autoLoad: true
        }
    }
});
