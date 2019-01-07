Ext.define('GrupoBruce.view.mantenimientoproceso.MantenimientoProcesoModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMmantenimientoproceso',

    data: {
        title: 'Proceso de Mantenimiento de Equipos Informaticos',
        fechaHoy: new Date(),
        codEtapa: null,
        selectSolucionador: null,
        selectMantenimiento: null,
        nextEstadoMantenimiento: null
    },

    stores: {
        mantenimientos: {
            type: 'Smantenimiento',
            autoLoad: true,
            filters: [{
                    property: 'ID_EMANTENIMIENTO',
                    operator: '{codEtapa !== null ? "eq" : "like"}',
                    value: '{codEtapa !== null ? codEtapa : "%"}'
                }]
        },
        estadosMantenimiento: {
            type: 'SestadoMantenimiento',
            autoLoad: true,
            filters: [{
                    property: 'ID_PRECEDE',
                    operator: 'EQ',
                    value: '{codEtapa}'
                }]
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
