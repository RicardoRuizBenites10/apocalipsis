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
            text: 'Fecha',
            dataIndex: 'fecha',
            formatter: 'date("d/m/Y")',
            align: 'center'
        }, {
            text: 'Observación',
            dataIndex: 'observacion',
            align: 'left',
            flex: 1
        }, {
            text: 'Generador',
            flex: 1
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'combobox',
                    reference: 'cbo_estadoMantenimiento',
                    fieldLabel: 'Mantenimiento',
                    valueField: 'idEmantenimiento',
                    displayField: 'descripcion',
                    editable: false,
                    bind: {
                        store: '{estadosMantenimiento}',
                        selection: '{selectEstadoMantenimiento}'
                    },
                    listeners: {
                        change: 'verificaProcesoMantenimiento'
                    }
                }, '-', {
                    xtype: 'button',
                    iconCls: 'x-fa fa-circle-o-notch',
                    text: 'Siguiente etapa',
                    bind: {
                        disabled: '{!selectMantenimiento}',
                        text: '{nextEstadoMantenimiento.accion}'
                    },
                    handler: 'addMantenimientoProceso'
                }, {
                    iconCls: 'x-fa fa-eye',
                    disabled: true,
                    text: 'Seguimiento',
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