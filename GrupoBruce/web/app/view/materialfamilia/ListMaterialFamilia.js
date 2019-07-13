Ext.define('GrupoBruce.view.materialfamilia.ListMaterialFamilia', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistmaterialfamilia',
    reference: 'list_materialfamilia',
    id: 'id_wlistmaterialfamilia',

    bind: {
        store: '{materialsfamilia}',
        selection: '{selectMaterialFamilia}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Descripción',
            dataIndex: 'descripcion',
            align: 'left',
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
            },
            align: 'center'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectMaterialFamilia}'
                    },
                    handler: 'addMaterialFamilia'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectMaterialFamilia}'
                    },
                    handler: 'editMaterialFamilia'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectMaterialFamilia}'
                    },
                    handler: 'deleteMaterialFamilia'
                }, '-', {
                    iconCls: 'x-fa fa-list',
                    disabled: true,
                    text: 'Lista subfamilias',
                    bind: {
                        disabled: '{!selectMaterialFamilia}'
                    },
                    handler: 'onMaterialSubfamilia'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{materialsfamilia}'
            },
            displayInfo: true
        }]
});