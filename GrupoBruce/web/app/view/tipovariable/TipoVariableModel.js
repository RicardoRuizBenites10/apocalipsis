Ext.define('GrupoBruce.view.tipovariable.TipoVariableModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtipovariable',
    data: {
        selectTipoVariable: null
    },

    stores: {
        tiposVariable: {
            type: 'StipoVariable',
            autoLoad: true
        }
    }

});
