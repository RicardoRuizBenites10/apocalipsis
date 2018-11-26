Ext.define('GrupoBruce.view.mantenimientoproceso.ListMantenimientoProceso', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistMantenimientoProceso',
    reference: 'list_mantenimientoProceso',

    bind: {
        store: '{mantenimientosProceso}',
        selection: '{selectMantenimientoProceso}'
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
                    }
                }, '-', {
                    xtype: 'button',
                    iconCls: 'x-fa fa-circle-o-notch',
                    text: 'Siguiente etapa',
                    bind: {
                        disabled: '{!selectMantenimientoProceso}'
                    },
                    handler: 'addMantenimientoProceso'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{mantenimientosProceso}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});