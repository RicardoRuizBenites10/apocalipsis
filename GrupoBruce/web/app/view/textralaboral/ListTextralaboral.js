Ext.define('GrupoBruce.view.textralaboral.ListTextralaboral', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistTextralaboral',
    reference: 'list_textralaboral',
    id: 'id_wlisttextralaboral',

    bind: {
        store: '{textralaborals}',
        selection: '{selectTextralaboral}'
    },
    allowDeselect: true,

    requires: [
        'Ext.grid.RowNumberer'
    ],

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            xtype: 'rownumberer'
        }, {
            text: 'Trabajador',
            dataIndex: 'trabajador',
            width: 400,
            align: 'left'
        }, {
            text: 'Fecha',
            dataIndex: 'fecha',
            align: 'center'
        }, {
            text: 'Inicio',
            dataIndex: 'horaInicio',
            formatter: 'date("d/m/Y")',
            align: 'center'
        }, {
            text: 'Fin',
            dataIndex: 'horaFin',
            formatter: 'date("d/m/Y")',
            align: 'center'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectTextralaboral}'
                },
                handler: 'addTextralaboral'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectTextralaboral}'
                },
                handler: 'editTextralaboral'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectTextralaboral}'
                },
                handler: 'deleteTextralaboral'
            }, '-', {
                iconCls: 'x-fa fa-retweet',
                disabled: true,
                text: 'Etapas de proceso',
                bind: {
                    disabled: '{!selectTextralaboral}'
                },
                handler: 'onEtapasTextralaboral'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{textralaborals}'
            },
            displayInfo: true
        }]
});