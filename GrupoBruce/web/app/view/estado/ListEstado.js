Ext.define('GrupoBruce.view.estado.ListEstado',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistEstado',
    reference: 'list_estado',
    
    bind: {
        store: '{estados}',
        selection: '{selectEstado}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idEstado',
            align: 'center'
        }, {
            text: 'Orden',
            dataIndex: 'orden',
            align: 'center'
        }, {
            text: 'Etapa actual',
            dataIndex: 'descripcion',
            align: 'left',
            width: 200
        },{
            text: 'Etapa anterior',
            dataIndex: 'precede',
            align: 'left',
            width: 200
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectEstado}'
                },
                handler: 'addEstado'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectEstado}'
                },
                handler: 'editEstado'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectEstado}'
                },
                handler: 'deleteEstado'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{estados}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
    
});