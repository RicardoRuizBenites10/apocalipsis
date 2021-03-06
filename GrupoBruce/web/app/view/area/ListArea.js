Ext.define('GrupoBruce.view.area.ListArea', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.WlistArea',
    reference: 'list_area',
    id: 'id_larea',

    bind: {
        store: '{areas}',
        selection: '{selectArea}'
    },
    allowDeselect: true,
    rootVisible: false,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idArea',
            align: 'center'
        }, {
            xtype: 'treecolumn',
            text: 'Área funcional',
            dataIndex: 'nombre',
            sortable: true,
            width: 400,
            align: 'left'
        },{
            text: 'Descripción',
            dataIndex: 'descripcion',
            width: 450,
            align: 'left'
        }, {
            text: 'Situacion',
            dataIndex: 'situacion',
            renderer: function (val) {
                return val ? 'Activo' : 'Desactivado';
            },
            align: 'center'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                disabled: true,
                text: 'Nuevo',
                bind: {
                    disabled: '{!selectArea}'
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
                text: 'Eliminar',
                disabled: true,
                bind: {
                    disabled: '{!selectArea}'
                },
                handler: 'deleteArea'
            },'-',{
                iconCls: 'x-fa fa-briefcase',
                text: 'Cargos',
                disabled: true,
                bind: {
                    disabled: '{!selectArea}'
                },
                handler: 'onCargos'
            }]
    }

});