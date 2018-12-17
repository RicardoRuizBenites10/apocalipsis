Ext.define('GrupoBruce.view.menu.ListMenu', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.WlistMenu',
    reference: 'list_menu',
    id: 'id_lmenu',

    viewConfig: {
        plugins: {
            ptype: 'treeviewdragdrop'
        }
        ,listeners: {
            drop: function (node, data, model, dropPosition) {
                alert('Node: ' + model.get('idMenu') + ' Data: ' + dropPosition);
            }
        }
    },

    bind: {
        title: '{title}',
        store: '{menus}',
        selection: '{selectMenu}'
    },
    allowDeselect: true,

    closable: true,
    rootVisible: false,
    useArrows: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idMenu',
            align: 'left'
        }, {
            xtype: 'treecolumn',
            text: 'Nombre',
            dataIndex: 'text',
            flex: 1,
            align: 'left'
        }, {
            text: 'handler',
            dataIndex: 'handler',
            flex: 1,
            align: 'left'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
//                disabled: true,
                text: 'Nuevo',
//                bind: {
//                    disabled: '{!selectMenu}'
//                },
                handler: 'addMenu'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectMenu}'
                },
                handler: 'editMenu'
            }, {
                iconCls: 'x-fa fa-trash',
                text: 'Eliminar',
                disabled: true,
                bind: {
                    disabled: '{!selectMenu}'
                },
                handler: 'deleteMenu'
            }]
    }
});