Ext.define('GrupoBruce.view.trabajador.Trabajador', {
    extend: 'Ext.panel.Panel',
    
    xtype: 'trabajadors',
    
    requires: [
        'GrupoBruce.view.trabajador.TrabajadorController',
        'GrupoBruce.view.trabajador.TrabajadorModel',
        
        'GrupoBruce.view.trabajador.TrabajadorList',
        'GrupoBruce.view.trabajador.TrabajadorForm'
    ],

    controller: 'Ctrabajador',
    viewModel: {
        type: 'VMtrabajador'
    },
    
    items: [{
        xtype: 'trabajadorList',
        reference: 'gridTrabajadors',
        height: 500
    }]

});
