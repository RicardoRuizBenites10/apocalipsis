Ext.define('GrupoBruce.view.asistencia.Asistencia', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.asistencia.AsistenciaController',
        'GrupoBruce.view.asistencia.AsistenciaModel',
        
        'GrupoBruce.view.asistencia.ListMarcas'
    ],

    controller: 'Casistencia',
    viewModel: {
        type: 'VMasistencia'
    },

    items: [{
            xtype: 'tabpanel',
            title: 'Monitoreo de empleados',
            header: {
                items: [{
                        xtype: 'button',
                        text: 'Marcaciones',
                        handler: 'onImportacionMarcas',
                        tooltip: {
                            title: 'Importar marcaciones',
                            text: 'Formato debe ser el indicado'
                        }
                    }]
            },

            items: [{
                    title: 'Calendario Bruce'
                }, {
                    title: 'Vista de equipo '
                }]
        }]

});
