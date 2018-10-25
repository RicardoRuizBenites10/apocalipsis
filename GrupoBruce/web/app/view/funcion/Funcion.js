
Ext.define('GrupoBruce.view.funcion.Funcion',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.funcion.FuncionController',
        'GrupoBruce.view.funcion.FuncionModel',
        
        'GrupoBruce.view.funcion.ListFuncion',
        'GrupoBruce.view.funcion.FormFuncion'
    ],

    controller: 'funcion-funcion',
    viewModel: {
        type: 'funcion-funcion'
    },

    html: 'Hello, World!!'
});
