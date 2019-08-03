Ext.define('GrupoBruce.view.materialunidad.MaterialUnidad', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wmaterialunidad',
    reference: 'materialunidad',
    id: 'id_wmaterialunidad',
    
    requires: [
        'GrupoBruce.view.materialunidad.MaterialUnidadController',
        'GrupoBruce.view.materialunidad.MaterialUnidadModel',
        
        'GrupoBruce.view.materialunidad.FormMaterialUnidad'
    ],
    
    controller: 'Cmaterialunidad',
    viewModel: {
        type: 'VMmaterialunidad'
    },
    bind: {
        store: '{materialunidads}',
        selection: '{selectMaterialUnidad}'
    },
    allowDeselect: true,
    height: 100,

    columns: [{
            text: 'Unidad',
            dataIndex: 'idUmedida',
            width: 122
        }, {
            text: 'Equivalencia',
            dataIndex: 'equivalencia',
            width: 122
        }, {
            text: 'Precio',
            dataIndex: 'precio',
            width: 122
        }],
    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Asignar',
                    bind: {
                        disabled: '{selectMaterial}'
                    },
                    handler: 'addMaterialUnidad'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Quitar',
                    bind: {
                        disabled: '{!selectMaterial}'
                    },
                    handler: 'deleteMaterialUnidad'
                }]
        }]
});
