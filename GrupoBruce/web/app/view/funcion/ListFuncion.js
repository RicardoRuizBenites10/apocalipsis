Ext.define('GrupoBruce.view.funcion.ListFuncion', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistFuncion',
    reference: 'list_funcion',
    
    bind: {
        store: '{funcions}',
        selection : '{selectFuncion}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Nombre',
            dataIndex: 'nombre',
            align: 'left',
            flex: 1
        }, {
            text: 'Decripción',
            dataIndex: 'detalle',
            align: 'left',
            flex: 1
        }, {
            text: 'Situacion',
            dataIndex: 'situacion',
            align: 'left',
            renderer: function (val) {
                return val ? 'Activo' : 'Inactivo';
            }
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectFuncion}'
                },
                handler: 'addFuncion'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectFuncion}'
                },
                handler: 'editFuncion'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectFuncion}'
                },
                handler: 'deleteFuncion'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{funcions}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]

});


