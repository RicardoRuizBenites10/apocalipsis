Ext.define('GrupoBruce.view.menu.MenuList',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.WmenuList',
    reference: 'menu_list',

    bind: {
        title: '{title}',
        store: '{areas}',
        selection: '{selectArea}'
    },
    allowDeselect: true,

    rootVisible: false,
//    singleExpand: true,
    closable: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns:[{
            text: 'Codigo'
    },{
        text: 'Descripción'
    }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                disabled: true,
                text: 'Nuevo',
                bind: {
                    disabled: '{!selectMenu}'
                },
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
            },'-',{
                iconCls: 'x-fa fa-briefcase',
                text: 'Cargos',
                disabled: true,
                bind: {
                    disabled: '{!selectMenu}'
                },
                handler: 'onCargos'
            }]
    }
});