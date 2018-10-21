
Ext.define('GrupoBruce.view.formacion.Formacion',{
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.formacion.FormacionController',
        'GrupoBruce.view.formacion.FormacionModel',
        
        'GrupoBruce.view.formacion.ListFormacion'
    ],

    controller: 'Cformacion',
    viewModel: {
        type: 'VMformacion'
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
            xtype: 'WlistFormacion',
            height: 360
    }]
});
