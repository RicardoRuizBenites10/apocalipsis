Ext.define('GrupoBruce.view.especificacionactividad.EspecificacionActividad', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wespecificacionactividad',
    id: 'id_wespecificacionactividad',

    requires: [
        'GrupoBruce.view.especificacionactividad.EspecificacionActividadController',
        'GrupoBruce.view.especificacionactividad.EspecificacionActividadModel',

        'GrupoBruce.view.especificacionactividad.FormEspecificacionActividad'
    ],

    controller: 'Cespecificacionactividad',
    viewModel: {
        type: 'VMespecificacionactividad'
    },

    bind: {
        store: '{especificacionactividads}',
        selection: '{selectEspecificacionActividad}'
    },
    allowDeselect: true,
    height: 300,

    columns: [{
            text: 'Código',
            dataIndex: 'idActividad'
        }, {
            text: 'Actividad',
            dataIndex: 'actividad',
            align: 'left',
            width: 200
        },{
            text: 'Área',
            dataIndex: 'etapa'
        }],
    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Agregar',
                    bind: {
                        disabled: '{selectEspecificacionActividad}'
                    },
                    handler: 'addEspecificacionActividad'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Quitar',
                    bind: {
                        disabled: '{!selectEspecificacionActividad}'
                    },
                    handler: 'deleteEspecificacionActividad'
                }]
        }]
});
