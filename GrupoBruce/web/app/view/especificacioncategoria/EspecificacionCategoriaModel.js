Ext.define('GrupoBruce.view.especificacioncategoria.EspecificacionCategoriaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMespecificacioncategoria',
    
    data: {
        selectEspecificacionCategoria: null
    },
    
    stores: {
        especificacioncategorias: {
            type: 'Sespecificacioncategoria',
            autoLoad: true
        }
    }
});
