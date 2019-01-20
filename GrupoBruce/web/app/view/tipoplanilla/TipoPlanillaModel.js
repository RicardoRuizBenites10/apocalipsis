Ext.define('GrupoBruce.view.tipoplanilla.TipoPlanillaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtipoplanilla',
    data: {
        selectTipoPlanilla: null
    },
    
    stores: {
        tiposPlanilla: {
            type: 'StipoPlanilla',
            autoLoad: true
        }
    }

});
