Ext.define('GrupoBruce.view.turno.ListTurno', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistTurno',
    reference: 'list_turno',
    id: 'id_wturno',

    requires: [
        'Ext.selection.CellModel'
    ],

    plugins: {
        ptype: 'cellediting',
        clicksToEdit: 1
    },

    bind: {
        store: '{turnos}',
        selection: '{selectTurno}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idTurno',
            align: 'center'
        }, {
            text: 'Descripción',
            dataIndex: 'descripcion',
            width: 300,
            align: 'left'
        }, {
            text: 'Labor semanal',
            columns: [{
                    text: 'Dias',
                    dataIndex: 'dlbSemana',
                    align: 'center'
                }, {
                    text: 'Hrs | Min',
                    dataIndex: 'mlbSemana',
                    sortable: false,
                    renderer: function (value) {
                        var h = Math.trunc(value / 60);
                        return h + 'hrs ' + (value - h * 60) + 'min';
                    },
                    align: 'center'
                }]
        }, {
            xtype: 'checkcolumn',
            dataIndex: 'actual',
            text: 'Activo',
            align: 'center',
            width: 150
        }],

    listeners: {
        cellclick: 'onSelectionChange'
    },

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectTurno}'
                },
                handler: 'addTurno'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectTurno}'
                },
                handler: 'editTurno'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectTurno}'
                },
                handler: 'deleteTurno'
            }, '-', {
                iconCls: 'x-fa fa-calendar-o',
                disabled: true,
                text: 'Horarios',
                bind: {
                    disabled: '{!selectTurno}'
                },
                handler: 'onHorarioTurno'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{turnos}'
            },
            displayInfo: true
        }]

});