Ext.define('GrupoBruce.view.requerimiento.RequerimientoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMrequerimiento',
    data: {
        selectObra: null,
        selectEtapaProceso: null
    },
    
    stores: {
        obras: {
            type: 'Sobra',
            autoLoad: true
        },
        eprocesos: {
            type: 'Setapaproceso',
            autoLoad: true
        }
    }
});
