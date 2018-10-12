Ext.define('GrupoBruce.view.hijo.Hijo', {
    extend: 'Ext.window.Window',
    reference: 'panel_hijo',

    requires: [
        'GrupoBruce.view.hijo.HijoController',
        'GrupoBruce.view.hijo.HijoModel',
        
        'GrupoBruce.view.hijo.ListHijoTrabajador',
        'GrupoBruce.view.hijo.FormHijoTrabajador'
    ],

    viewModel: {
        type: 'VMhijo'
    },
    controller: 'Chijo',

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
