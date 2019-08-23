Ext.define('GrupoBruce.view.sucursal.ListSucursal', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistSucursal',
    reference: 'list_sucursal',

    bind: {
        store: '{sucursals}',
        selection: '{selectSucursal}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idSucursal',
            align: 'center'
        }, {
            text: 'Descripción',
            dataIndex: 'descripcion',
            align: 'left'
        }, {
            text: 'Direccion',
            dataIndex: 'direccion',
            width: 300,
            align: 'left'
        }, {
            text: 'Teléfono',
            dataIndex: 'telefono',
            align: 'left'
        }, {
            text: 'Situación',
            dataIndex: 'situacion',
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
                    disabled: '{selectSucursal}'
                },
                handler: 'addSucursal'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectSucursal}'
                },
                handler: 'editSucursal'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectSucursal}'
                },
                handler: 'deleteSucursal'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{sucursals}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});