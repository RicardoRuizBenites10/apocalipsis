Ext.define('GrupoBruce.view.tipotrabajador.TipoTrabajador', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.tipotrabajador.TipoTrabajadorController',
        'GrupoBruce.view.tipotrabajador.TipoTrabajadorModel',

        'GrupoBruce.view.tipotrabajador.ListTipoTrabajador',
        'GrupoBruce.view.tipotrabajador.FormTipoTrabajador'
    ],

    controller: 'Ctipotrabajador',
    viewModel: {
        type: 'VMtipotrabajador'
    },

    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistTipoTrabajador',
            id: 'id_wtipotrabajador',
            height: 500
        }]
});
