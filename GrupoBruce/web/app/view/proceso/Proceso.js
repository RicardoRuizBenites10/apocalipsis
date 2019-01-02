Ext.define('GrupoBruce.view.proceso.Proceso', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.Wproceso',
    reference: 'proceso',

    requires: [
        'GrupoBruce.view.proceso.ProcesoController',
        'GrupoBruce.view.proceso.ProcesoModel',
        
        'GrupoBruce.view.proceso.ListProceso',
        'GrupoBruce.view.proceso.FormProceso'
    ],

    controller: 'Cproceso',
    viewModel: {
        type: 'VMproceso'
    },

    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistProceso',
            id: 'id_wproceso',
            height: 500
        }]
});
