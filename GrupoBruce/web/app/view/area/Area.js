Ext.define('GrupoBruce.view.area.Area', {
    extend: 'Ext.container.Container',

    requires: [
        'GrupoBruce.view.area.AreaController',
        'GrupoBruce.view.area.AreaModel',

        'GrupoBruce.view.area.FormArea',
        'GrupoBruce.view.area.ListArea'
    ],

    controller: 'Carea',
    viewModel: {
        type: 'VMarea'
    },

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    items: [{
            xtype: 'WlistArea',
            height: 520,
            width: 650
        }]

});
