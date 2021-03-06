Ext.define('GrupoBruce.view.actividad.ListActividad', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistActividad',
    reference: 'list_actividad',
    id: 'id_wlistactividad',

    bind: {
        store: '{actividads}',
        selection: '{selectActividad}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Código',
            dataIndex: 'idActividad'
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            align: 'left',
            width: 200
        }, {
            text: 'Tiempo',
            dataIndex: 'duracion'
        }, {
            text: 'Actualizado',
            dataIndex: 'fecha',
            formatter: 'date("d/m/Y")'
        }, {
            text: 'Situación',
            dataIndex: 'situacion',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            },
            align: 'center'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectActividad}'
                    },
                    handler: 'addActividad'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectActividad}'
                    },
                    handler: 'editActividad'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectActividad}'
                    },
                    handler: 'deleteActividad'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{actividads}'
            },
            displayInfo: true
        }]

});