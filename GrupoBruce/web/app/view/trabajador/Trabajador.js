Ext.define('GrupoBruce.view.trabajador.Trabajador', {
    extend: 'Ext.panel.Panel',
    
    xtype: 'trabajadors',
    
    requires: [
        'GrupoBruce.view.trabajador.TrabajadorController',
        'GrupoBruce.view.trabajador.TrabajadorModel',
        
        'GrupoBruce.view.trabajador.ListTrabajador',
        'GrupoBruce.view.trabajador.FormTrabajador',
        
        'GrupoBruce.model.Trabajador'
    ],

    controller: 'Ctrabajador',
    viewModel: {
        type: 'VMtrabajador'
    },
    
    items: [{
        xtype: 'wlistTrabajador',
        height: 575,
        flex: 4
    },{
        xtype: 'panel',
        flex: 1,
        title: 'Relacionados'
    }]

});
