Ext.define('GrupoBruce.view.tipovariable.TipoVariable',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.tipovariable.TipoVariableController',
        'GrupoBruce.view.tipovariable.TipoVariableModel',
        
        'GrupoBruce.view.tipovariable.FormTipoVariable',
        'GrupoBruce.view.tipovariable.ListTipoVariable'
    ],

    controller: 'Ctipovariable',
    viewModel: {
        type: 'VMtipovariable'
    },

    title: 'Lista de tipos de variable',
    items: [{
            xtype: 'WlistTipoVariable',
            height: 500
    }]
});
