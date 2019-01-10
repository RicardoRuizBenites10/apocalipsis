Ext.define('GrupoBruce.view.comisionrp.ListComisionrp', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistComisionrp',
    reference: 'list_comisionrp',

    bind: {
        store: '{comisionsrp}',
        selection: '{selectComisionrp}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idComisionrp',
            align: 'center'
        }, {
            text: 'Descripción',
            dataIndex: 'descripcion',
            width: 200,
            align: 'left'
        }, {
            text: 'Fondo',
            dataIndex: 'fondo'
        }, {
            text: 'Seguro',
            dataIndex: 'seguro'
        }, {
            text: 'Comision',
            dataIndex: 'comision'
        }],

    tbar: {
        overflowHandler: 'menu',
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectComisionrp}'
                },
                handler: 'addComisionrp'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectComisionrp}'
                },
                handler: 'editComisionrp'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{comisionsrp}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});