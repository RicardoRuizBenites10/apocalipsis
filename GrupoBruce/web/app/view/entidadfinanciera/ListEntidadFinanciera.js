Ext.define('GrupoBruce.view.entidadfinanciera.ListEntidadFinanciera', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistEntidadFinanciera',
    reference: 'list_entidadFinanciera',

    bind: {
        store: '{entidadsFinanciera}',
        selection: '{selectEntidadFinanciera}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idEfinanciera',
            align: 'center'
        }, {
            text: 'Entidad ',
            dataIndex: 'nombre',
            align: 'left',
            width: 250
        }, {
            text: 'Estado',
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

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectEntidadFinanciera}'
                },
                handler: 'addEntidadFinanciera'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectEntidadFinanciera}'
                },
                handler: 'editEntidadFinanciera'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectEntidadFinanciera}'
                },
                handler: 'deleteEntidadFinanciera'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{entidadsFinanciera}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});