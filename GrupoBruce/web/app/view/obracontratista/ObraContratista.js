Ext.define('GrupoBruce.view.obracontratista.ObraContratista', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wobracontratista',
    reference: 'obra_contratista',
    id: 'id_wobracontratista',

    requires: [
        'GrupoBruce.view.obracontratista.ObraContratistaController',
        'GrupoBruce.view.obracontratista.ObraContratistaModel',

        'GrupoBruce.view.obracontratista.FormObraContratista'
    ],

    controller: 'Cobracontratista',
    viewModel: {
        type: 'VMobracontratista'
    },

    bind: {
        store: '{obracontratistas}',
        selection: '{selectObraContratista}'
    },
    allowDeselect: true,
    minHeight: 380,

    columns: [{
            text: 'Área producción',
            dataIndex: 'etapa',
            width: 150
        }, {
            text: 'Contratista',
            dataIndex: 'contratista'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    text: 'Agregar',
                    iconCls: 'x-fa fa-plus',
                    bind: {
                        disabled: '{selectObraContratista}'
                    },
                    handler: 'addObraContratista'
                }, {
                    text: 'Quitar',
                    iconCls: 'x-fa fa-trash',
                    bind: {
                        disabled: '{!selectObraContratista}'
                    },
                    handler: 'deleteObraContratista'
                }]
        }]

});
