Ext.define('GrupoBruce.view.asignaciondetalle.AsignacionDetalleModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasignaciondetalle',

    data: {
        title: 'Equipos asignados',
        recordAsignacion: null
    },

    stores: {
        asignacionsDetalle: {
            type: 'SasignacionDetalle',
            autoLoad: true,
            filters: [{
                    property: 'idAequipo',
                    value: '{recordAsignacion.idAequipo}'
                }]
        }
    }

});
