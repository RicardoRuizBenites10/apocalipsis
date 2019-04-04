Ext.define('GrupoBruce.view.horario.ListHorario', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistHorario',
    reference: 'list_horario',
    id: 'id_wlisthorario',

    bind: {
        store: '{horarios}',
        selection: '{selectHorario}'
    },
    allowDeselect: true,

    requires: [
        'Ext.grid.RowNumberer'
    ],

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'rownumberer'
        }, {
            text: 'Dia',
            dataIndex: 'dia',
            width: 120,
            align: 'left'
        }, {
            text: 'Situación',
            dataIndex: 'libre',
            align: 'center',
            renderer: function (value) {
                return value ? 'Cerrado' : 'Abierto';
            }
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
        }, {
            text: 'Estado',
            dataIndex: 'situacion',
            width: 150,
            align: 'center',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            }
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectHorario}'
                },
                handler: 'addHorario'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectHorario}'
                },
                handler: 'editHorario'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectHorario}'
                },
                handler: 'deleteHorario'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{horarios}'
            },
            displayInfo: true
        }]
});