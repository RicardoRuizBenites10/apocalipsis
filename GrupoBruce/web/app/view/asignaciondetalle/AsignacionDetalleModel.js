Ext.define('GrupoBruce.view.asignaciondetalle.AsignacionDetalleModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMasignaciondetalle',

    data: {
        title: 'Equipos asignados',
        recordAsignacion: null,
        selectAsignacionDetalle: null
    },

    stores: {
        asignacionsDetalle: {
            type: 'SasignacionDetalle',
            autoLoad: true,
            filters: [{
                    property: 'ID_AEQUIPO',
                    value: '{recordAsignacion.idAequipo}'
                }]
        },
        equiposInformatico: {
            type: 'SequipoInformatico',
            autoLoad: true,
            proxy: {
                type: 'ajax',
                url: 'equiposPorAsignar',
                reader: {
                    type: 'json',
                    rootProperty: 'data',
                    totalProperty: 'total',
                    successProperty: 'success'
                },
                writer: {
                    type: 'json',
                    writeAllFields: true
                }
            }
        }
    }

});
