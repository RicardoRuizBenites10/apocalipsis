Ext.define('GrupoBruce.view.comisionrp.Comisionrp', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.comisionrp.ComisionrpController',
        'GrupoBruce.view.comisionrp.ComisionrpModel',

        'GrupoBruce.view.comisionrp.ListComisionrp',
        'GrupoBruce.view.comisionrp.FormComisionrp'
    ],

    controller: 'Ccomisionrp',
    viewModel: {
        type: 'VMcomisionrp'
    },
    
    resizable: false,
    modal: true,
    closable: true,
    autoShow: true,
    
    bind: {
      title: '{title}'  
    },
    items: [{
            xtype: 'WlistComisionrp',
            id: 'id_wcomisionrp',
            height: 400,
            width: 600
        }]
});
