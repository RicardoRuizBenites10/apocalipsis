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
            formatter: 'date("d/m/Y")',
            align: 'center'
        }, {
            text: 'Tipo',
            dataIndex: 'tipotextra',
            align: 'left'
        }, {
            text: 'Inicio',
            dataIndex: 'horaInicio',
            formatter: 'date("h:i A")',
            align: 'center'
        }, {
            text: 'Fin',
            dataIndex: 'horaSalida',
            formatter: 'date("h:i A")',
            align: 'center'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'datefield',
                id: 'id_dateDesde',
                reference: 'date_desde',
                fieldLabel: 'F. seguimiento',
                format: 'd/m/Y',
                bind: '{desde}'
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