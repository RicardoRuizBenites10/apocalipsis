Ext.define('GrupoBruce.view.chasisproveedor.ListChasisProveedor', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistchasisproveedor',
    reference: 'list_chasisproveedor',
    id: 'id_wlistchasisproveedor',

    bind: {
        store: '{chasisproveedors}',
        selection: '{selectChasisProveedor}'
    },
    allowDeselect: true,

    title: 'Lista de proveedores de chasis',
    columns: [{
            text: 'Código',
            dataIndex: 'idChapro',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            align: 'left',
            width: 400
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
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectChasisProveedor}'
                    },
                    handler: 'addChasisProveedor'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectChasisProveedor}'
                    },
                    handler: 'editChasisProveedor'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectChasisProveedor}'
                    },
                    handler: 'deleteChasisProveedor'
                }, '-', {
                    text: 'Chasises',
                    iconCls: 'x-fa fa-list',
                    disabled: true,
                    bind: {
                        disabled: '{!selectChasisProveedor}'
                    },
                    handler: 'onChasis'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{chasisproveedors}'
            },
            displayInfo: true
        }]
});