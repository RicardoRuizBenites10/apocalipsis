Ext.define('GrupoBruce.view.chasis.ListChasis', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistchasis',
    reference: 'list_chasis',
    id: 'id_wlistchasis',

    bind: {
        store: '{chasiss}',
        selection: '{selectChasis}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Tipo carrocería',
            dataIndex: 'carroceria',
            align: 'left',
            width: '200'
        }, {
            text: 'Nombre',
            dataIndex: 'modelo',
            align: 'left',
            width: 300
        }, {
            text: 'D.D.E.E.',
            dataIndex: 'ddee',
            align: 'left'
        }],
    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectChasis}'
                    },
                    handler: 'addChasis'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectChasis}'
                    },
                    handler: 'editChasis'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectChasis}'
                    },
                    handler: 'deleteChasis'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{chasiss}'
            },
            displayInfo: true
        }]
});