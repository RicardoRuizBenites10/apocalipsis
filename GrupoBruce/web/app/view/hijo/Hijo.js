
Ext.define('GrupoBruce.view.hijo.Hijo', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.hijo.HijoController',
        'GrupoBruce.view.hijo.HijoModel'
    ],

    controller: 'Chijo',
    viewModel: {
        type: 'VMhijo'
    },

    height: 400,
    width: 600,
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,
    bind: {
        title: '{title}'
    },

    items: [{
            xtype: 'WhijoTrabajador',
            height: 355
        }]
});
