Ext.define('GrupoBruce.view.empresa.ListEmpresa', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistEmpresa',
    reference: 'list_empresa',

    bind: {
        store: '{empresas}',
        selection: '{selectEmpresa}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idEmpresa',
            align: 'center'
        }, {
            text: 'RUC',
            dataIndex: 'ruc',
            width: 150,
            align: 'center'
        }, {
            text: 'Empresa',
            dataIndex: 'descripcion',
            width: 300,
            align: 'left'
        }, {
            text: 'Situación',
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
                    disabled: '{selectEmpresa}'
                },
                handler: 'addEmpresa'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectEmpresa}'
                },
                handler: 'editEmpresa'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectEmpresa}'
                },
                handler: 'deleteEmpresa'
            }, '-', {
                iconCls: 'x-fa fa-building-o',
                disabled: true,
                text: 'Sucursales',
                bind: {
                    disabled: '{!selectEmpresa}'
                },
                handler: 'onSucursalEmpresa'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{empresas}'
            },
            displayInfo: true
        }]

});