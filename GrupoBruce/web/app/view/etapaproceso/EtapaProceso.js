Ext.define('GrupoBruce.view.etapaproceso.EtapaProceso',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.etapaproceso.EtapaProcesoController',
        'GrupoBruce.view.etapaproceso.EtapaProcesoModel',
        
        'GrupoBruce.view.etapaproceso.ListEtapaProceso',
        'GrupoBruce.view.etapaproceso.FormEtapaProceso'
    ],

    controller: 'Cetapaproceso',
    viewModel: {
        type: 'VMetapaproceso'
    },
    
    bind: {
      title: '{titulo}'  
    },
    items: [{
        xtype: 'Wlistetapaproceso',
        height: 500
    }]

});
