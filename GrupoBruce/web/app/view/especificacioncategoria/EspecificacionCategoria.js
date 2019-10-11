Ext.define('GrupoBruce.view.especificacioncategoria.EspecificacionCategoria',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.especificacioncategoria.EspecificacionCategoriaController',
        'GrupoBruce.view.especificacioncategoria.EspecificacionCategoriaModel',
        
        'GrupoBruce.view.especificacioncategoria.FormEspecificacionCategoria',
        'GrupoBruce.view.especificacioncategoria.ListEspecificacionCategoria'
    ],

    controller: 'Cespecificacioncategoria',
    viewModel: {
        type: 'VMespecificacioncategoria'
    },

    title: 'Lista de categorias de especificación',
    items: [{
            xtype: 'Wlistespecificacioncategoria',
            height: 520
    }]
});
