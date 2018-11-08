Ext.define('GrupoBruce.view.equipo.ListEquipo', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistEquipo',
    reference: 'list_equipo',
    
    bind: {
        store: '{equiposInformatico}',
        selection: '{selectEquipo}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Nombre',
            dataIndex: 'denominacion',
            flex: 2
        }, {
            text: 'Tipo'
        }, {
            text: 'Estado'
        }],

    tbar: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-plus',
                text: 'Nuevo',
                bind: {
                    disabled: '{selectEquipo}'
                },
                handler: 'addEquipo'
            }, {
                iconCls: 'x-fa fa-edit',
                disabled: true,
                text: 'Modificar',
                bind: {
                    disabled: '{!selectEquipo}'
                },
                handler: 'editEquipo'
            }, {
                iconCls: 'x-fa fa-trash',
                disabled: true,
                text: 'Eliminar',
                bind: {
                    disabled: '{!selectEquipo}'
                },
                handler: 'deleteEquipo'
            }]
    },

    dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{equiposInformatico}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar"
        }]
});
