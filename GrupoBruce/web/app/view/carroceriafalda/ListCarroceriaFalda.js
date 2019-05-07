Ext.define('GrupoBruce.view.carroceriafalda.ListCarroceriaFalda', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistcarroceriafalda',
    reference: 'list_carroceriafalda',
    id: 'id_wlistcarroceriafalda',

    bind: {
        store: '{carroceriafaldas}',
        selection: '{selectCarroceriaFalda}'
    },
    allowDeselect: true,
    title: 'Lista de faldas carrocería',

    columns: [{
            text: 'Código',
            dataIndex: 'idCarfal',
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
            dock: 'top',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectCarroceriaFalda}'
                    },
                    handler: 'addCarroceriaFalda'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectCarroceriaFalda}'
                    },
                    handler: 'editCarroceriaFalda'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectCarroceriaFalda}'
                    },
                    handler: 'deleteCarroceriaFalda'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{carroceriafaldas}'
            },
            displayInfo: true
        }]
});