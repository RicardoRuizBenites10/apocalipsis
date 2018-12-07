
Ext.define('GrupoBruce.view.menu.Menu',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.menu.MenuController',
        'GrupoBruce.view.menu.MenuModel'
    ],

    controller: 'Cmenu',
    viewModel: {
        type: 'VMmenu'
    },

    html: 'Hello, World!!'
});
