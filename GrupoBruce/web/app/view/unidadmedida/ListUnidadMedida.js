Ext.define('GrupoBruce.view.unidadmedida.ListUnidadMedida', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistunidadmedida',
    reference: 'list_unidadmedida',
    id: 'id_wlistunidadmedida',

    bind: {
        store: '{unidadsmedida}',
        selection: '{selectUnidadMedida}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Código',
            dataIndex: 'idUmedida',
            align: 'center'
        }, {
            text: 'Denominación',
            dataIndex: 'denominacion',
            align: 'left',
            width: 200
        }, {
            text: 'Equivalencia',
            dataIndex: 'equivalencia'
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
                        disabled: '{selectUnidadMedida}'
                    },
                    handler: 'addUnidadMedida'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectUnidadMedida}'
                    },
                    handler: 'editUnidadMedida'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectUnidadMedida}'
                    },
                    handler: 'deleteUnidadMedida'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{unidadsmedida}'
            },
            displayInfo: true
        }]
});