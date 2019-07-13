Ext.define('GrupoBruce.view.materialfamilia.MaterialFamilia', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.materialfamilia.MaterialFamiliaController',
        'GrupoBruce.view.materialfamilia.MaterialFamiliaModel',

        'GrupoBruce.view.materialfamilia.ListMaterialFamilia',
        'GrupoBruce.view.materialfamilia.FormMaterialFamilia'
    ],

    controller: 'Cmaterialfamilia',
    viewModel: {
        type: 'VMmaterialfamilia'
    },

    bind: {
        title: '{titulo}'
    },
    items: [{
            xtype: 'Wlistmaterialfamilia',
            height: 500
        }]
});
