Ext.define('GrupoBruce.view.menu.Menu',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.menu.MenuController',
        'GrupoBruce.view.menu.MenuModel',
        
        'GrupoBruce.view.menu.ListMenu',
        'GrupoBruce.view.menu.FormMenu'
    ],

    controller: 'Cmenu',
    viewModel: {
        type: 'VMmenu'
    },

    items: [{
            xtype: 'WlistMenu',
            height: 500
    }]
});