Ext.define('GrupoBruce.view.asistencia.Asistencia', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.asistencia.AsistenciaController',
        'GrupoBruce.view.asistencia.AsistenciaModel',

        'GrupoBruce.view.asistencia.ListMarcacion',
        'GrupoBruce.view.asistencia.FormMarcacion'
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
                    title: 'Vista de equipo ',
                    items: [{
                            xtype: 'grid',
                            tbar: {
                                items: [{
                                        xtype: 'button',
                                        iconCls: 'x-fa fa-plus',
                                        text: 'Nueva marca',
                                        handler: 'addMarcacion'
                                    }]
                            }
                        }]
                },{
                    title: 'Calendario Bruce'
                }]
        }]

});
