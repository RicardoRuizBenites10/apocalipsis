
Ext.define('GrupoBruce.view.area.Area',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.area.AreaController',
        'GrupoBruce.view.area.AreaModel',
        
        'GrupoBruce.view.area.ListArea',
        'GrupoBruce.view.area.FormArea'
    ],

    controller: 'Carea',
    viewModel: {
        type: 'VMarea'
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
            xtype: 'WlistArea',
            width: 355
    }]

});
