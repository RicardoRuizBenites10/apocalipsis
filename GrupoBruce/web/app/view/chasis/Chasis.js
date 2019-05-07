Ext.define('GrupoBruce.view.chasis.Chasis',{
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.chasis.ChasisController',
        'GrupoBruce.view.chasis.ChasisModel',
        
        'GrupoBruce.view.chasis.FormChasis',
        'GrupoBruce.view.chasis.ListChasis'
    ],

    controller: 'Cchasis',
    viewModel: {
        type: 'VMchasis'
    },

    modal: true,
    autoShow: true,
    title: 'Chasis de proveedor',

    items: [{
            xtype: 'Wlistchasis',
            width: 600,
            height: 350
        }]
});
