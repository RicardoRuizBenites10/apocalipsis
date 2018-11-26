Ext.define('GrupoBruce.view.mantenimientoproceso.MantenimientoProcesoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmantenimientoproceso',

    data: {
        title: 'Proceso de Mantenimiento de Equipos Informaticos',
        fechaHoy: new Date(),
        selectSolucionador: null,
        selectMantenimientoProceso: null,
        selectEstadoMantenimiento: null,
        nextEstadoMantenimiento: null
    },

    stores: {
        mantenimientosProceso: {
            type: 'SmantenimientoProceso',
            autoLoad: true,
            filters: [{
                    property: 'idEmantenimiento',
                    value: '{selectEstadoMantenimiento.idEmantenimiento}'
                }]
        },
        estadosMantenimiento: {
            type: 'SestadoMantenimiento',
            autoLoad: true
        },
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true,
            sorters: [
                {property: 'apPaterno', direction: 'ASC'},
                {property: 'apMaterno', direction: 'ASC'},
                {property: 'nombres', direction: 'ASC'}
            ],
            listeners: {
                beforeload: function (store) {
                    var query = Ext.getCmp('id_solucionador');
                    var valor = query !== undefined ? query.getValue() : 'x1';
                    store.getProxy().setExtraParam("query", valor);
                }
            }
        }
    }
});
