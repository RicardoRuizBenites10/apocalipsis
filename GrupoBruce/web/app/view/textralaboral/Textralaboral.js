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
    
    title: 'Lista de horas extras',
    items: [{
            xtype: 'WlistTextralaboral',
            height: 500
        }]
});
