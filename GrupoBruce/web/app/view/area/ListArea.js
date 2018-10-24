Ext.define('GrupoBruce.view.area.ListArea', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.WlistArea',
    reference: 'list_area',
    
    bind:{
        store: '{areas}',
        title: '{title}'
    },
    allowDeselect: true,

    reserveScrollbar: true,
    rootVisible: false,
    multiSelect: true,
    singleExpand: true,
    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'treecolumn',
            text: 'Nombre',
            dataIndex: 'nombre',
            sortable: false,
            flex: 1
        }],
    
    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectHijo}'
                },
                handler: 'addHijo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectHijo}'
                },
                handler: 'editHijo'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectHijo}'
                },
                handler: 'deleteHijo'
            }]
    }

});