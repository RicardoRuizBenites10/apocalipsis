Ext.define('GrupoBruce.view.proveedor.ListProveedor', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistproveedor',
    reference: 'list_proveedor',
    id: 'id_wlistproveedor',

    bind: {
        store: '{proveedors}',
        selection: '{selectProveedor}'
    },
    allowDeselect: true,

    columns: [{
            text: 'RUC',
            dataIndex: 'idProveedor',
            align: 'left',
            width: 150
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            align: 'left',
            width: 400
        }, {
            text: 'Correo',
            dataIndex: 'correo',
            align: 'left',
            width: 220
        }, {
            text: 'Teléfono',
            dataIndex: 'telefono',
            align: 'left'
        }, {
            text: 'Sitruación',
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

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectProveedor}'
                    },
                    handler: 'addProveedor'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectProveedor}'
                    },
                    handler: 'editProveedor'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectProveedor}'
                    },
                    handler: 'deleteProveedor'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{proveedors}'
            },
            displayInfo: true
        }]
});