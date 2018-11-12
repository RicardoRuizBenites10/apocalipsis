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
            text: 'IP'
        }, {
            text: 'Trabajador',
            flex: 1
        }, {
            text: 'Usuario'
        }, {
            text: 'Contraseña'
        }, {
            text: 'Fecha'
        }],

    tbar: {
        items: [{
                xtype: 'button',
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
            }]
    },

    dockedItems: [{
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