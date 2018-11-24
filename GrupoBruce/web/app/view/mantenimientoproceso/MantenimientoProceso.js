Ext.define('GrupoBruce.view.mantenimientoproceso.MantenimientoProceso', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.mantenimientoproceso.MantenimientoProcesoController',
        'GrupoBruce.view.mantenimientoproceso.MantenimientoProcesoModel',

        'GrupoBruce.view.mantenimientoproceso.FormMantenimientoProceso',
        'GrupoBruce.view.mantenimientoproceso.ListMantenimientoProceso'
    ],

    controller: 'Cmantenimientoproceso',
    viewModel: {
        type: 'VMmantenimientoproceso'
    },

    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistMantenimientoProceso',
            id: 'id_wmantenimientoProceso',
            height: 450
        }]
});
