Ext.define('GrupoBruce.view.mantenimientoeinformatico.MantenimientoEinformatico',{
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.mantenimientoeinformatico.MantenimientoEinformaticoController',
        'GrupoBruce.view.mantenimientoeinformatico.MantenimientoEinformaticoModel',
        
        'GrupoBruce.view.mantenimientoeinformatico.ListMantenimientoEinformatico',
        'GrupoBruce.view.mantenimientoeinformatico.FormMantenimientoEinformatico'
    ],

    controller: 'Cmantenimientoeinformatico',
    viewModel: {
        type: 'VMmantenimientoeinformatico'
    },

    bind: {
        title: '{title}'
    },
    
    modal: true,
    closable: true,
    resizable: false,
    autoShow: true,

    items:[{
            xtype: 'WmantenimientoEinformatico',
            id: 'id_wmantenimientoEinformatico',
            width: 600,
            height: 400
    }]
});
