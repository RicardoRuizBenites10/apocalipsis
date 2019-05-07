Ext.define('GrupoBruce.view.carroceriatipo.ListCarroceriaTipo', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistcarroceriatipo',
    reference: 'list_carroceriatipo',
    id: 'id_wlistcarroceriatipo',

    bind: {
        store: '{carroceriatipos}',
        selection: '{selectCarroceriaTipo}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Código',
            dataIndex: 'idCartip',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            align: 'left',
            width: 300
        }, {
            text: 'Situación',
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
                        disabled: '{selectCarroceriaTipo}'
                    },
                    handler: 'addCarroceriaTipo'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectCarroceriaTipo}'
                    },
                    handler: 'editCarroceriaTipo'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectCarroceriaTipo}'
                    },
                    handler: 'deleteCarroceriaTipo'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{carroceriatipos}'
            },
            displayInfo: true
        }]
});