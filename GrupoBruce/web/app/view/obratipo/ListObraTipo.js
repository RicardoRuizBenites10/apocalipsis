Ext.define('GrupoBruce.view.obratipo.ListObraTipo', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistobratipo',
    reference: 'list_obratipo',
    id: 'id_wlistobratipo',

    bind: {
        store: '{obratipos}',
        selection: '{selectObraTipo}'
    },
    allowDeselect: true,
    
    columns: [{
            text: 'Código',
            dataIndex: 'idObrtip'
        }, {
            text: 'Descripción',
            dataIndex: 'descripcion',
            width: 250
        }, {
            text: 'Situación',
            dataIndex: 'situacion',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            }
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectObraTipo}'
                    },
                    handler: 'addObraTipo'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectObraTipo}'
                    },
                    handler: 'editObraTipo'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectObraTipo}'
                    },
                    handler: 'deleteObraTipo'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{obratipos}'
            },
            displayInfo: true
        }]

});