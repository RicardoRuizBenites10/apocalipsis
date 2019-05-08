Ext.define('GrupoBruce.view.carroceria.ListCarroceria', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistcarroceria',
    reference: 'list_carroceria',
    id: 'id_wlistcarroceria',

    bind: {
        store: '{carrocerias}',
        selection: '{selectCarroceria}'
    },
    allowDeselect: true,

    title: 'Lista de carrocerías',
    columns: [{
            text: 'Código',
            dataIndex: 'idCarroceria',
            align: 'left'
        },{
            text: 'Tipo',
            dataIndex: 'tipo',
            align: 'left'
        },{
            text: 'Subtipo',
            dataIndex: 'subtipo',
            align: 'left',
            width: 200
        },{
            text: 'Proveedor',
            dataIndex: 'proveedor',
            align: 'left',
            width: 200
        }, {
            text: 'Descripcion',
            dataIndex: 'descripcion',
            align: 'left',
            width: 350
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
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectCarroceria}'
                    },
                    handler: 'addCarroceria'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectCarroceria}'
                    },
                    handler: 'editCarroceria'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectCarroceria}'
                    },
                    handler: 'deleteCarroceria'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{carrocerias}'
            },
            displayInfo: true
        }]
});