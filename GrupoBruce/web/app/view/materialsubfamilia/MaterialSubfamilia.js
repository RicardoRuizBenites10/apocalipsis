Ext.define('GrupoBruce.view.materialsubfamilia.MaterialSubfamilia',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.materialsubfamilia.MaterialSubfamiliaController',
        'GrupoBruce.view.materialsubfamilia.MaterialSubfamiliaModel'
    ],

    controller: 'materialsubfamilia-materialsubfamilia',
    viewModel: {
        type: 'materialsubfamilia-materialsubfamilia'
    },

    html: 'Hello, World!!'
});
