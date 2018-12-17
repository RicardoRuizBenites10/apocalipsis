Ext.define('GrupoBruce.view.acceso.ListAcceso', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.WlistAcceso',
    reference: 'list_acceso',

    bind: {
        store: '{accesosRol}',
        selection: '{selectAcceso}'
    },

    rootVisible: false,
    useArrows: true,

    checkPropagation: 'down',
//    frame: true,
//    bufferedRenderer: false,
//    animate: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'treecolumn',
            text: 'Nombre',
            dataIndex: 'text',
            width: 500,
            align: 'left'
        }, {
            text: 'Codigo',
            dataIndex: 'idMenu',
            width: 100,
            align: 'left'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-save',
                text: 'Guardar',
                handler: 'saveAcceso'
            }]
    },

    listeners: {
        checkchange: 'onChangeSelect'
    }

});