Ext.define('GrupoBruce.view.colordiseno.ListColorDiseno', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistcolordiseno',
    reference: 'list_colordiseno',
    id: 'id_wlistcolordiseno',

    bind: {
        store: '{colordisenos}',
        selection: '{selectColorDiseno}'
    },
    allowDeselect: true,

    title: 'Lista de colores de diseño',
    columns: [{
            text: 'Código',
            dataIndex: 'idCdiseno',
            width: 200
        }, {
            text: 'Denominacion',
            dataIndex: 'denominacion',
            width: 400
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectColorDiseno}'
                    },
                    handler: 'addColorDiseno'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectColorDiseno}'
                    },
                    handler: 'editColorDiseno'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectColorDiseno}'
                    },
                    handler: 'deleteColorDiseno'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{colordisenos}'
            },
            displayInfo: true
        }]
});