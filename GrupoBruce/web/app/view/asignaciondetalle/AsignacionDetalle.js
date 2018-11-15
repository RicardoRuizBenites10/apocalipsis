Ext.define('GrupoBruce.view.asignaciondetalle.AsignacionDetalle', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.asignaciondetalle.AsignacionDetalleController',
        'GrupoBruce.view.asignaciondetalle.AsignacionDetalleModel',

        'GrupoBruce.view.asignaciondetalle.ListAsignacionDetalle',
        'GrupoBruce.view.asignaciondetalle.FormAsignacionDetalle'
    ],

    controller: 'Casignaciondetalle',
    viewModel: {
        type: 'VMasignaciondetalle'
    },

    bind: {
        title: '{title}'
    },

    closable: true,
    resizable: false,
    modal: true,
    autoShow: true,

    items: [{
            xtype: 'WasignacionDetalle',
            width: 600,
            height: 400
        }]

});
