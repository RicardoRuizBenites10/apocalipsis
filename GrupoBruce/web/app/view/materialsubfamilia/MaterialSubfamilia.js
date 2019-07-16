Ext.define('GrupoBruce.view.materialsubfamilia.MaterialSubfamilia', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.materialsubfamilia.MaterialSubfamiliaController',
        'GrupoBruce.view.materialsubfamilia.MaterialSubfamiliaModel',

        'GrupoBruce.view.materialsubfamilia.FormMaterialSubfamilia',
        'GrupoBruce.view.materialsubfamilia.ListMaterialSubfamilia'
    ],

    controller: 'Cmaterialsubfamilia',
    viewModel: {
        type: 'VMmaterialsubfamilia'
    },

    modal: true,
    resizable: false,
    autoShow: true,
    
    title: 'Lista de subfamilias',
    items: [{
            xtype: 'Wlistmaterialsubfamilia',
            width: 600,
            height: 350
        }]
});
