Ext.define('GrupoBruce.view.especificacion.EspecificacionModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMespecificacion',
    data: {
        name: 'GrupoBruce'
    },
    
    stores: {
        especificacions: {
            type: 'Sespecificacion',
            autoLoad: true
        },
        especificacioncategorias : {
            type: 'Sespecificacioncategoria',
            autoLoad: true
        }
    }

});
