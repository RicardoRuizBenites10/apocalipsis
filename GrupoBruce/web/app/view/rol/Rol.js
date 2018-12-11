Ext.define('GrupoBruce.view.rol.Rol',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.rol.RolController',
        'GrupoBruce.view.rol.RolModel',
        
        'GrupoBruce.view.rol.ListRol'
    ],

    controller: 'Crol',
    viewModel: {
        type: 'VMrol'
    },
    
    items: [{
            xtype: 'WlistRol',
            height: 500
    }]
});
