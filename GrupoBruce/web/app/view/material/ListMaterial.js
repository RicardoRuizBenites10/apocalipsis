Ext.define('GrupoBruce.view.material.ListMaterial', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistmaterial',
    reference: 'list_material',
    id: 'id_wlistmaterial',

    bind: {
        store: '{materials}',
        selection: '{selectMaterial}'
    },
    allowDeselect: true,
    columns: [{
            text: 'Nombre',
            dataIndex: 'nombre',
            width: 300,
            align: 'left'
        }, {
            text: 'Ingresado',
            dataIndex: 'cantIngreso'
        }, {
            text: 'Salida',
            dataIndex: 'cantSalida'
        }, {
            text: 'Stock',
            dataIndex: 'stock'
        }, {
            text: 'Precio',
            dataIndex: 'precio'
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
                        disabled: '{selectMaterial}'
                    },
                    handler: 'addMaterial'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectMaterial}'
                    },
                    handler: 'editMaterial'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectMaterial}'
                    },
                    handler: 'deleteMaterial'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{materials}'
            },
            displayInfo: true
        }]
});