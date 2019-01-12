
Ext.define('GrupoBruce.view.marca.Marca',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.marca.MarcaController',
        'GrupoBruce.view.marca.MarcaModel'
    ],

    controller: 'Cmarca',
    viewModel: {
        type: 'VMmarca'
    },

    html: 'Hello, World!!'
});
