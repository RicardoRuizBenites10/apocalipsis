
Ext.define('GrupoBruce.view.material.Material',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.material.MaterialController',
        'GrupoBruce.view.material.MaterialModel'
    ],

    controller: 'material-material',
    viewModel: {
        type: 'material-material'
    },

    html: 'Hello, World!!'
});
