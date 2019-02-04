Ext.define('GrupoBruce.view.calendario.ListCalendario', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistCalendario',
    reference: 'list_calendario',
    id: 'id_wlistcalendario',

    bind: {
        store: '{calendarios}',
        selection: '{selectCalendario}'
    },
    allowDeselect: true,

    requires: [
        'Ext.grid.RowNumberer'
    ],

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'rownumberer'
        }, {
            text: 'Fecha',
            dataIndex: 'fecha',
            formatter: 'date("d/m/Y")',
            align: 'center'
        }, {
            text: 'Situación',
            dataIndex: 'libre',
            align: 'center',
            renderer: function (value) {
                return value ? 'Cerrado' : 'Abierto';
            }
        }, {
            text: 'Descripción',
            dataIndex: 'descripcion',
            width: 300,
            align: 'left'
        }, {
            text: 'Entrada',
            dataIndex: 'horaEntrada',
            formatter: 'date("h:i A")',
            align: 'left'
        }, {
            text: 'Salida',
            dataIndex: 'horaSalida',
            formatter: 'date("h:i A")',
            align: 'left'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectCalendario}'
                },
                handler: 'addCalendario'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectCalendario}'
                },
                handler: 'editCalendario'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectCalendario}'
                },
                handler: 'deleteCalendario'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{calendarios}'
            },
            displayInfo: true
        }]
});