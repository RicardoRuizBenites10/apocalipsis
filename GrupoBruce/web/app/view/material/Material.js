Ext.define('GrupoBruce.view.material.Material', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.material.MaterialController',
        'GrupoBruce.view.material.MaterialModel',

        'GrupoBruce.view.material.ListMaterial',
        'GrupoBruce.view.material.FormMaterial'
    ],

    controller: 'Cmaterial',
    viewModel: {
        type: 'VMmaterial'
    },

    bind: {
        title: '{titulo}'
    },

    items: [{
            xtype: 'Wlistmaterial',
            height: 500
        }]
});
