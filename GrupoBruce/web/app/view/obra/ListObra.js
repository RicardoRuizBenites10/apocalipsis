Ext.define('GrupoBruce.view.obra.ListObra', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistobra',
    reference: 'list_obra',
    id: 'id_wlistobra',

    bind: {
        store: '{obras}',
        selection: '{selectObra}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Tipo'
        }, {
            text: 'Nombre'
        }, {
            text: 'Cliente',
            width: 300
        }, {
            text: 'Inicio'
        }, {
            text: 'Fin'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectObra}'
                    },
                    handler: 'addObra'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectObra}'
                    },
                    handler: 'editObra'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectObra}'
                    },
                    handler: 'deleteObra'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{obras}'
            },
            displayInfo: true
        }]
});