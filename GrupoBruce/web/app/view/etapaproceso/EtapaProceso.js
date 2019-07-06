
Ext.define('GrupoBruce.view.etapaproceso.EtapaProceso',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.etapaproceso.EtapaProcesoController',
        'GrupoBruce.view.etapaproceso.EtapaProcesoModel'
    ],

    controller: 'Cetapaproceso',
    viewModel: {
        type: 'VMetapaproceso'
    },

    html: 'Hello, World!!'
});
