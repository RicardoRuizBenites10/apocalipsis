Ext.define('GrupoBruce.view.chasis.ChasisModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMchasis',

    stores: {
        chasiss: {
            type: 'Schasis',
            autoLoad: true
        },
        carroceriamodelos: {
            type: 'Scarroceriamodelo',
            autoLoad: true
        }
    }
});
