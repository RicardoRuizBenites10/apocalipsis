Ext.define('GrupoBruce.view.contratista.ListContratista', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistcontratista',
    reference: 'list_contratista',
    id: 'id_wlistcontratista',

    bind: {
        store: '{contratistas}',
        selection: '{selectContratista}'
    },
    allowDeselect: true,

    columns: [{
            text: 'RUC',
            dataIndex: 'idContratista',
            width: 150,
            align: 'left'
        }, {
            text: 'Nombre',
            dataIndex: 'nombre',
            width: 300,
            align: 'left'
        }, {
            text: 'Teléfono',
            dataIndex: 'telefono'
        }, {
            text: 'Área producción',
            dataIndex: 'etapaProceso',
            width: 250,
            align: 'left'
        }, {
            text: 'Situacion',
            dataIndex: 'situacion',
            align: 'center',
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
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectContratista}'
                    },
                    handler: 'addContratista'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectContratista}'
                    },
                    handler: 'editContratista'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectContratista}'
                    },
                    handler: 'deleteContratista'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{contratistas}'
            },
            displayInfo: true
        }]
});