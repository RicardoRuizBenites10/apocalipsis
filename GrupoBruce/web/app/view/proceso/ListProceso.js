Ext.define('GrupoBruce.view.proceso.ListProceso', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistProceso',
    reference: 'list_proceso',

    bind: {
        store: '{procesos}',
        selection: '{selectProceso}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idProceso',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            width: 500,
            align: 'left'
        }, {
            text: 'Estado',
            dataIndex: 'estado',
            width: 150,
            align: 'center'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectProceso}'
                },
                handler: 'addProceso'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectProceso}'
                },
                handler: 'editProceso'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectProceso}'
                },
                handler: 'deleteProceso'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{procesos}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});