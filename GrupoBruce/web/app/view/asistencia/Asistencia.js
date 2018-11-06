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
                        iconCls: 'fa fa-plus',
                        text: 'Marcaciones',
                        handler: 'onImportacionMarcas',
                        tooltip: {
                            title: 'Archivo excel con formato:',
                            text: 'Dpto | Nombres | Dni | Fecha/hora'
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
