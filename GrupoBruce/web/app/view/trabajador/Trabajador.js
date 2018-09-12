Ext.define('GrupoBruce.view.trabajador.Trabajador', {
    extend: 'Ext.panel.Panel',
    
    xtype: 'trabajadors',
    
    requires: [
        'GrupoBruce.view.trabajador.TrabajadorController',
        'GrupoBruce.view.trabajador.TrabajadorModel',
        
        'GrupoBruce.view.trabajador.List',
        'GrupoBruce.view.trabajador.Form',
        
        'GrupoBruce.model.Trabajador'
    ],

    controller: 'Ctrabajador',
    viewModel: {
        type: 'VMtrabajador'
    },
    
    items: [{
        xtype: 'listTrabajador',
        reference: 'gridTrabajador',
        height: 530
    }]

});
