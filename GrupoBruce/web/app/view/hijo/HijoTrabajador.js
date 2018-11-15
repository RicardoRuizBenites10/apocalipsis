Ext.define('GrupoBruce.view.hijo.HijoTrabajador', {
    extend: 'Ext.window.Window',
    reference: 'panel_hijo',

    requires: [
        'GrupoBruce.view.hijo.HijoTrabajadorController',
        'GrupoBruce.view.hijo.HijoTrabajadorModel',

        'GrupoBruce.view.hijo.ListHijoTrabajador',
        'GrupoBruce.view.hijo.FormHijoTrabajador'
    ],

    viewModel: {
        type: 'VMhijo'
    },
    controller: 'Chijo',

    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,

    bind: {
        title: '{title}'
    },

    items: [{
            xtype: 'WhijoTrabajador',
            height: 400,
            width: 600
        }]
});
