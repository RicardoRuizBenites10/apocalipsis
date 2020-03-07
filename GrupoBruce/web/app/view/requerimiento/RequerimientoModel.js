Ext.define('GrupoBruce.view.requerimiento.RequerimientoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMrequerimiento',
    data: {
        selectObra: null
    },

    stores: {
        obras: {
            type: 'Sobra',
            autoLoad: true
        }
    }
});
