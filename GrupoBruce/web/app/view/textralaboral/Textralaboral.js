Ext.define('GrupoBruce.view.textralaboral.Textralaboral', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.textralaboral.TextralaboralController',
        'GrupoBruce.view.textralaboral.TextralaboralModel',

        'GrupoBruce.view.textralaboral.FormTextralaboral',
        'GrupoBruce.view.textralaboral.ListTextralaboral'
    ],

    controller: 'Ctextralaboral',
    viewModel: {
        type: 'VMtextralaboral'
    },

    items: [{
            xtype: 'WlistTextralaboral',
            title: 'Lista de horas extras',
            header: {
                items: [{
                        xtype: 'button',
                        iconCls: 'x-fa fa-plus',
                        text: 'Programar',
                        handler: 'addTextralaboral'
                    }]
            },
            height: 500
        }]
});
