
Ext.define('GrupoBruce.view.funcion.Funcion', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.funcion.FuncionController',
        'GrupoBruce.view.funcion.FuncionModel',

        'GrupoBruce.view.funcion.ListFuncion',
        'GrupoBruce.view.funcion.FormFuncion'
    ],

    controller: 'Cfuncion',
    viewModel: {
        type: 'VMfuncion'
    },

    modal: true,
    closable: true,
    resizable: false,
    autoShow: true,
    
    bind: {
        title: '{title}'
    },
    
    items: [{
            xtype: 'WlistFuncion',
            width: 600,
            height: 400
        }]
});
