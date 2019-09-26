Ext.define('GrupoBruce.view.menu.ListMenu', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.WlistMenu',
    reference: 'list_menu',
    id: 'id_lmenu',

//    viewConfig: {
//        plugins: {
//            ptype: 'gridviewdragdrop',
//            expandDelay: 1000
//        }
//        , listeners: {
//            drop: function (node, data, overModel, dropPosition, dropHandlers) {
////                dropHandlers.wait = true;
////                Ext.MessageBox.confirm('Drop', 'Esta seguro', function (btn) {
//////                    console.log(btn);
////                    if (btn === 'yes') {
////                        dropHandlers.processDrop();
////                console.log('Node: ' + overModel.get('idMenu') + ' - ' + overModel.get('idSupmenu') + ' Position: ' + dropPosition);
////                    } else {
////                        dropHandlers.cancelDrop();
////                    }
////                });
//
////                data.records[0].set('idSupmenu',overModel.get('idSupmenu'));
//                console.log(overModel);
//                console.log(data.records[0]);
////                data.records[0].save();
//////                console.log(node.getStore().reload());
////                Ext.getCmp('id_lmenu').getStore().reload();
//            }
//        }
//    },

    bind: {
        title: '{title}',
        store: '{menus}',
        selection: '{selectMenu}'
    },
    allowDeselect: true,
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
                text: 'Nuevo',
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