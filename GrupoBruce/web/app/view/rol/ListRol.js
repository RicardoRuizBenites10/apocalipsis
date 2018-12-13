Ext.define('GrupoBruce.view.rol.ListRol', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistRol',
    reference: 'list_rol',
    
    bind: {
        title: '{title}',
        store: '{rols}',
        selection: '{selectRol}'
    },
    allowDeselect: true,

    style: 'border: solid rgb(234,234,236) 1px',
    columns: [{
            text: 'Código',
            dataIndex: 'idRol',
            align: 'center'
    },{
            text: 'Denominación',
            dataIndex: 'denominacion',
            align: 'left',
            flex: 1
        }],
    
    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    text: 'Nuevo',
                    iconCls: 'x-fa fa-plus',
                    bind: {
                        disabled: '{selectRol}'
                    },
                    listeners: {
                        click: 'addRol'
                    }
                }, {
                    text: 'Editar',
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    bind: {
                        disabled: '{!selectRol}'
                    },
                    listeners: {
                        click: 'editRol'
                    }
                }, {
                    text: 'Eliminar',
                    iconCls: 'x-fa fa-trash',
                    disabled: true
                    ,bind: {
                        disabled: '{!selectRol}'
                    },
                    listeners: {
                        click: 'deleteRol'
                    }
                },'-',{
                    text: 'Accesos',
                    iconCls: 'x-fa fa-dot-circle-o',
                    disabled: true
                    ,bind: {
                        disabled: '{!selectRol}'
                    },
                    listeners: {
                        click: 'onAccesoRol'
                    }
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{rols}'
            },
            displayInfo: true,
            displayMsg: 'Mostrando registros {0} - {1} de {2}',
            emptyMsg: "No hay registros que mostrar",
            overflowHandler: 'scroller'
        }]
});