Ext.define('GrupoBruce.view.especificacioncategoria.ListEspecificacionCategoria', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.Wlistespecificacioncategoria',
    reference: 'list_especificacioncategoria',
    id: 'id_wlistespecificacioncategoria',

    bind: {
        store: '{especificacioncategorias}',
        selection: '{selectEspecificacionCategoria}'
    },
    allowDeselect: true,
    rootVisible: false,
    useArrows: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idEcategoria'
        }, {
            xtype: 'treecolumn',
            text: 'Nombre',
            dataIndex: 'nombre',
            sortable: true,
            width: 400,
            align: 'left'
        }, {
            text: 'Actualizado',
            formatter: 'date("d/m/Y")',
            dataIndex: 'fechaUpdate'
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
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    handler: 'addEspecificacionCategoria'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectEspecificacionCategoria}'
                    },
                    handler: 'editEspecificacionCategoria'
                }, {
                    iconCls: 'x-fa fa-trash',
                    text: 'Eliminar',
                    disabled: true,
                    bind: {
                        disabled: '{!selectEspecificacionCategoria}'
                    },
                    handler: 'deleteEspecificacionCategoria'
                }]
        }]
});