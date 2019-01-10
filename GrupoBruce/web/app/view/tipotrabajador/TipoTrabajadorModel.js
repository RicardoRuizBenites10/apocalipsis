Ext.define('GrupoBruce.view.tipotrabajador.TipoTrabajadorModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMtipotrabajador',
    data: {
        title: 'Lista de tipos de trabajador',
        selectTipoTrabajador: null
    },

    stores: {
        tiposTrabajador: {
            type: 'StipoTrabajador',
            autoLoad: true
        }
    }

});
