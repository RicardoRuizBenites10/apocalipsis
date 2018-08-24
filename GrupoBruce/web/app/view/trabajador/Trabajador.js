Ext.define('GrupoBruce.view.trabajador.Trabajador', {
    extend: 'Ext.panel.Panel',
    
    xtype: 'trabajadors',
    
    requires: [
        'GrupoBruce.view.trabajador.TrabajadorController',
        'GrupoBruce.view.trabajador.TrabajadorModel',
        
        'GrupoBruce.view.trabajador.TrabajadorList',
        'GrupoBruce.view.trabajador.TrabajadorForm',
        'GrupoBruce.view.trabajador.PersonaForm'
    ],

    controller: 'Ctrabajador',
    viewModel: {
        type: 'VMtrabajador'
    },
    
    items: [{
        xtype: 'trabajadorList',
        reference: 'gridTrabajador',
        height: 500
    }]

});
