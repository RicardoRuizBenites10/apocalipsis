Ext.define('GrupoBruce.view.tipovariable.ListTipoVariable',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistTipoVariable',
    reference: 'list_tipoVariable',
    id: 'id_wlisttipovariable',

    bind: {
        store: '{tiposVariable}',
        selection: '{selectTipoVariable}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idTipo',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'descripcion',
            width: 400,
            align: 'left'
        }, {
            text: 'Estado',
            dataIndex: 'situacion',
            width: 150,
            align: 'center',
            renderer: function (val) {
                if (val) {
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> ACTIVO </span>';
                } else {
                    return '<span style="background:#d9534f;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> INACTIVO </span>';
                }
            }
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectTipoVariable}'
                },
                handler: 'addTipoVariable'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectTipoVariable}'
                },
                handler: 'editTipoVariable'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectTipoVariable}'
                },
                handler: 'deleteTipoVariable'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{tiposVariable}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});