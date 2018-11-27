Ext.define('GrupoBruce.view.mantenimientoproceso.MantenimientoProceso', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.WmantenimientoProceso',
    reference: 'mantenimientoProceso',

    requires: [
        'GrupoBruce.view.mantenimientoproceso.MantenimientoProcesoController',
        'GrupoBruce.view.mantenimientoproceso.MantenimientoProcesoModel',

        'GrupoBruce.view.mantenimientoproceso.FormMantenimientoProceso',
        'GrupoBruce.view.mantenimientoproceso.ListMantenimientoProceso',
        'GrupoBruce.view.mantenimientoproceso.ListSeguimientoProceso'
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
