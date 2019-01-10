Ext.define('GrupoBruce.view.empresa.Empresa',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.empresa.EmpresaController',
        'GrupoBruce.view.empresa.EmpresaModel',
        
        'GrupoBruce.view.empresa.ListEmpresa',
        'GrupoBruce.view.empresa.FormEmpresa'
    ],

    controller: 'Cempresa',
    viewModel: {
        type: 'VMempresa'
    },
    
    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistEmpresa',
            id: 'id_wempresa',
            height: 500
    }]
});
