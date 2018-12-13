Ext.define('GrupoBruce.view.acceso.ListAcceso', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistAcceso',
    reference: 'list_acceso',

    bind: {
        store: '{accesosRol}'
    },
    
    rootVisible: false,
    useArrows: true,
    
//    checkPropagation: 'both',
//    frame: true,
//    bufferedRenderer: false,
//    animate: true,

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
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-save',
                text: 'Guardar',
                handler: 'saveAcceso'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{accesosRol}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});