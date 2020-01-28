Ext.define('GrupoBruce.view.requerimiento.RequerimientoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMrequerimiento',
    data: {
        name: 'GrupoBruce'
    },
    
    stores: {
        obras: {
            type: 'Sobra',
            autoLoad: true
        }
    }
});
