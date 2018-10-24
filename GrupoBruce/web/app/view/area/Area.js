Ext.define('GrupoBruce.view.area.Area', {
    extend: 'Ext.container.Container',

    requires: [
        'GrupoBruce.view.area.AreaController',
        'GrupoBruce.view.area.AreaModel',

        'GrupoBruce.view.area.FormArea'
    ],

    controller: 'Carea',
    viewModel: {
        type: 'VMarea'
    },

    layout: {
        type: 'hbox',
        align: 'stretch'
    },

    items: [{
            xtype: 'treepanel',
            bind: {
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
                    text: 'Código',
                    dataIndex: 'idArea'
                }, {
                    xtype: 'treecolumn',
                    text: 'Nombre',
                    dataIndex: 'nombre',
                    sortable: false,
                    flex: 1
                }, {
                    text: 'Situacion',
                    dataIndex: 'situacion'
                }],
            tbar: {
                items: [{
                        xtype: 'button',
                        iconCls: 'x-fa fa-plus',
                        text: 'Nuevo',
                        bind: {
                            disabled: '{selectArea}'
                        },
                        handler: 'addArea'
                    }, {
                        iconCls: 'x-fa fa-edit',
                        disabled: true,
                        text: 'Modificar',
                        bind: {
                            disabled: '{!selectArea}'
                        },
                        handler: 'editArea'
                    }, {
                        iconCls: 'x-fa fa-trash',
                        disabled: true,
                        text: 'Eliminar',
                        bind: {
                            disabled: '{!selectArea}'
                        },
                        handler: 'deleteArea'
                    }]
            },
            width: 600,
            height: 520
        }]

});
