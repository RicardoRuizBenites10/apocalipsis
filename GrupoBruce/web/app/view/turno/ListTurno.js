Ext.define('GrupoBruce.view.turno.ListTurno',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistTurno',
    reference: 'list_turno',
    id: 'id_wturno',

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
            text: 'Situación',
            dataIndex: 'actual',
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
                iconCls: 'x-fa fa-building-o',
                disabled: true,
                text: 'Sucursales',
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