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
            text: 'Tipo',
            dataIndex: 'tipo'
        }, {
            text: 'Nombre',
            dataIndex: 'nombre'
        }, {
            text: 'Cliente',
            dataIndex: 'cliente',
            width: 270
        }, {
            text: 'Inicio',
            formatter: 'date("d/m/Y")',
            dataIndex: 'fechaIngreso',
            align: 'center'
        }, {
            text: 'Fin',
            formatter: 'date("d/m/Y")',
            dataIndex: 'fechaSalida',
            align: 'center'
        },{
            text: 'Pintura',
            dataIndex: 'gopintura',
            renderer: function(value){
                return value ? 'Go' : '-';
            },
            align: 'center'
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
                },'-',{
                    text: 'Referente a Pintura',
                    bind: {
                        disabled: '{!selectObra}'
                    },
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