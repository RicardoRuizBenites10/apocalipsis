Ext.define('GrupoBruce.view.obrapintura.ListObraPintura',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistobrapintura',
    reference: 'list_obrapintura',
    id: 'id_wlistobrapintura',
    
    bind: {
        store: '{obrapinturas}',
        selection: '{selectObraPintura}'
    },
    allowDeselect: true,
    
    columns: [{
            text: 'Código',
            dataIndex: 'idCdiseno'
    },{
        text: 'Nombre',
        dataIndex: 'colordiseno',
        width: 350
    }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    text: 'Agregar',
                    iconCls: 'x-fa fa-plus',
                    bind: {
                        disabled: '{selectObraPintura}'
                    },
                    handler: 'addObraPintura'
                }, {
                    text: 'Quitar',
                    iconCls: 'x-fa fa-trash',
                    bind: {
                        disabled: '{!selectObraPintura}'
                    },
                    handler: 'deleteObraPintura'
                }]
        }]
});