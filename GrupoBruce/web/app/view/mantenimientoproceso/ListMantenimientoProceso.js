Ext.define('GrupoBruce.view.mantenimientoproceso.ListMantenimientoProceso', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistMantenimientoProceso',
    reference: 'list_mantenimientoProceso',

    bind: {
        store: '{mantenimientos}',
        selection: '{selectMantenimiento}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idMantenimiento',
            align: 'center'
        }, {
            text: 'Fecha',
            dataIndex: 'fecha',
            formatter: 'date("d/m/Y")',
            align: 'center'
        }, {
            text: 'Observación',
            dataIndex: 'observacion',
            width: 250,
            align: 'left'
        }, {
            text: 'Generador',
            dataIndex: 'generador',
            width: 250,
            align: 'left'
        }, {
            text: 'Situación',
            dataIndex: 'etapa',
            width: 250,
            align: 'center'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Siguiente',
                    hidden:true,
                    bind: {
                        store: '{estadosMantenimiento}',
                        selection: '{nextEstadoMantenimiento}',
                        hidden: '{!codEtapa}'
                    },
                    valueField: 'idEmantenimiento',
                    displayField: 'descripcion',
                    editable: false,
                    listeners: {
                        change: 'verificaProcesoMantenimiento'
                    }
                }, {
                    xtype: 'button',
                    iconCls: 'x-fa fa-tasks',
                    text: 'Siguiente etapa',
                    hidden: true,
                    bind: {
                        disabled: '{!selectMantenimiento}',
                        text: '{nextEstadoMantenimiento.accion}',
                        hidden: '{!nextEstadoMantenimiento}'
                    },
                    handler: 'addMantenimientoProceso'
                }, {
                    iconCls: 'x-fa fa-eye',
                    disabled: true,
                    text: 'Ver detalle',
                    bind: {
                        disabled: '{!selectMantenimiento}'
                    },
                    handler: 'seguimientoMantenimientoProceso'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{mantenimientos}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});