Ext.define('GrupoBruce.view.actividad.ListActividad',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.WlistActividad',
    reference: 'list_actividad',
    id: 'id_wlistactividad',
    
    bind: {
        store: '{actividads}',
        selection: '{selectActividad}'
    },
    allowDeselect: true,
    
    columns: [{
            text: 'Código',
            dataIndex: 'idActividad'
    },{
        text: 'Nombre'
    },{
        text: 'Tiempo'
    },{
        text: 'Actualizado'
    }],
    
    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    xtype: 'button',
                    iconCls: 'x-fa fa-plus',
                    text: 'Nuevo',
                    bind: {
                        disabled: '{selectActividad}'
                    },
                    handler: 'addActividad'
                }, {
                    iconCls: 'x-fa fa-edit',
                    disabled: true,
                    text: 'Modificar',
                    bind: {
                        disabled: '{!selectActividad}'
                    },
                    handler: 'editActividad'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Eliminar',
                    bind: {
                        disabled: '{!selectActividad}'
                    },
                    handler: 'deleteActividad'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{actividads}'
            },
            displayInfo: true
        }]
    
});