Ext.define('GrupoBruce.view.asistencia.Asistencia', {
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.asistencia.AsistenciaController',
        'GrupoBruce.view.asistencia.AsistenciaModel',

        'GrupoBruce.view.marca.ListMarcaImport',
        'GrupoBruce.view.asistencia.ListAsistencia',
        'GrupoBruce.view.marca.FormMarca'
    ],

    controller: 'Casistencia',
    viewModel: {
        type: 'VMasistencia'
    },

    items: [{
            xtype: 'WlistAsistencia',
            title: 'Lista de asistencia',
            header: {
                items: [{
                        xtype: 'button',
                        iconCls: 'fa fa-plus',
                        text: 'Marcaciones',
                        handler: 'onMarcaImport',
                        tooltip: {
                            title: 'Archivo excel con formato:',
                            text: 'Dpto | Nombres | Dni | Fecha/hora'
                        }
                    }]
            },
            height: 500
        }]

});
