Ext.define('GrupoBruce.view.proforma.ListProforma', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistproforma',
    reference: 'list_proforma',
    id: 'id_wlistproforma',

    bind: {
        store: '{proformas}',
        selection: '{selectProforma}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Código',
            dataIndex: 'idProforma'
        },{
            text: 'Carrocería',
            dataIndex: 'idCarroceria'
        },{
            text: 'Cliente',
            dataIndex: 'cliente',
            width: 400
        },  {
            text: 'Actualización',
            dataIndex: 'fechaUpdate',
            formatter: 'date("d/m/Y")'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    text: 'Nuevo',
                    iconCls: 'x-fa fa-plus',
                    bind: {
                        disabled: '{selectProforma}'
                    },
                    handler: 'addProforma'
                }, {
                    text: 'Editar',
                    iconCls: 'x-fa fa-edit',
                    bind: {
                        disabled: '{!selectProforma}'
                    },
                    handler: 'editProforma'
                }, {
                    text: 'Eliminar',
                    iconCls: 'x-fa fa-trash',
                    bind: {
                        disabled: '{!selectProforma}'
                    },
                    handler: 'deleteProforma'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{proformas}'
            },
            displayInfo: true
        }]
});