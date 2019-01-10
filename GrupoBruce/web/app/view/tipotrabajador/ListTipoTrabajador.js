Ext.define('GrupoBruce.view.tipotrabajador.ListTipoTrabajador', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistTipoTrabajador',
    reference: 'list_tipoTrabajador',

    bind: {
        store: '{tiposTrabajador}',
        selection: '{selectTipoTrabajador}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Codigo',
            dataIndex: 'idTtrabajador',
            align: 'center'
        }, {
            text: 'Nombre',
            dataIndex: 'descripcion',
            width: 200,
            align: 'left'
        }, {
            text: 'R. pensionario',
            dataIndex: 'hasrpensionario',
            renderer: function (val) {
                return val ? 'SI' : 'NO';
            },
            width: 150,
            align: 'center'
        }, {
            text: 'Cta. CTS',
            dataIndex: 'hasctacts',
            renderer: function (val) {
                return val ? 'SI' : 'NO';
            },
            width: 150,
            align: 'center'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectTipoTrabajador}'
                },
                handler: 'addTipoTrabajador'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectTipoTrabajador}'
                },
                handler: 'editTipoTrabajador'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectTipoTrabajador}'
                },
                handler: 'deleteTipoTrabajador'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{tiposTrabajador}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});