Ext.define('GrupoBruce.view.asignacion.ListAsignacion', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAsignacion',
    reference: 'list_asignacion',

    bind: {
        store: '{asignacions}',
        selection: '{selectAsignacion}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'IP',
            dataIndex: 'nroIp',
            align: 'left',
            width: 130
        }, {
            text: 'Custodio',
            dataIndex: 'recepcionador',
            align: 'left',
            width: 350
        }, {
            text: 'Usuario',
            dataIndex: 'nomUsu',
            align: 'left'
        }, {
            text: 'Contraseña',
            dataIndex: 'pasUsu',
            align: 'left'
        }, {
            text: 'Fecha',
            dataIndex: 'fecha',
            formatter: 'date("d/m/Y")',
            align: 'center'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectAsignacion}'
                    },
                    handler: 'addAsignacion'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectAsignacion}'
                    },
                    handler: 'editAsignacion'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectAsignacion}'
                    },
                    handler: 'deleteAsignacion'
                }, '-', {
                    text: 'Asignación',
                    iconCls: 'x-fa fa-check-square',
                    disabled: true,
                    bind: {
                        disabled: '{!selectAsignacion}'
                    },
                    handler: 'onAsignacion'
                }, {
                    text: 'Mantenimiento',
                    iconCls: 'x-fa fa-wrench',
                    disabled: true,
                    bind: {
                        disabled: '{!selectAsignacion}'
                    },
                    handler: 'onMantenimiento'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{asignacions}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});