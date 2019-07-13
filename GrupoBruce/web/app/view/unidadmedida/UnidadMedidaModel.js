Ext.define('GrupoBruce.view.unidadmedida.UnidadMedidaModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMunidadmedida',

    data: {
        titulo: 'Lista de unidades de medida'
    },

    stores: {
        unidadsmedida: {
            type: 'Sunidadmedida',
            autoLoad: true
        }
    }

});
