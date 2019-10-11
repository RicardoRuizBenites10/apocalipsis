Ext.define('GrupoBruce.view.area.Area', {
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
    
    title: 'Lista de áreas funcionales',
    items: [{
            xtype: 'WlistArea',
            height: 520
        }]

});
