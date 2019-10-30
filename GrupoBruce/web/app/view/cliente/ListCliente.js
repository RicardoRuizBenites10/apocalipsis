Ext.define('GrupoBruce.view.cliente.ListCliente', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistcliente',
    reference: 'list_cliente',
    id: 'id_wlistcliente',

    bind: {
        store: '{clientes}',
        selection: '{selectCliente}'
    },
    allowDeselect: true,

    columns: [{
            text: 'N.Ident.',
            dataIndex: 'idCliente',
            align: 'left'
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            width: 300,
            align: 'left'
        }, {
            text: 'Teléfono',
            dataIndex: 'telefono',
            width: 200,
            align: 'left'
        }, {
            text: 'Correo',
            dataIndex: 'correo',
            width: 250,
            align: 'left'
        }, {
            text: 'Situacion',
            dataIndex: 'situacion',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            },
            align: 'center'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    text: 'Nuevo',
                    iconCls: 'x-fa fa-plus',
                    bind: {
                        disabled: '{selectCliente}'
                    },
                    handler: 'addCliente'
                }, {
                    text: 'Editar',
                    iconCls: 'x-fa fa-edit',
                    bind: {
                        disabled: '{!selectCliente}'
                    },
                    handler: 'editCliente'
                }, {
                    text: 'Eliminar',
                    iconCls: 'x-fa fa-trash',
                    bind: {
                        disabled: '{!selectCliente}'
                    },
                    handler: 'deleteCliente'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{clientes}'
            },
            displayInfo: true
        }]
});