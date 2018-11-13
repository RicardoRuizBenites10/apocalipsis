Ext.define('GrupoBruce.view.asignacion.Asignacion',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.asignacion.AsignacionController',
        'GrupoBruce.view.asignacion.AsignacionModel',
        
        'GrupoBruce.view.asignacion.ListAsignacion',
        'GrupoBruce.view.asignacion.FormAsignacion'
    ],

    controller: 'Casignacion',
    viewModel: {
        type: 'VMasignacion'
    },
    
    bind: {
        title: '{title}'
    },
    items: [{
            xtype: 'WlistAsignacion',
            id: 'id_wasignacion',
            height: 500
    }]
});
