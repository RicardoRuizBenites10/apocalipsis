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
    height: 150,

    columns: [{
            text: 'Unidad',
            dataIndex: 'idUmedida',
            width: 70,
            align: 'left'
        }, {
            text: 'Equivalencia',
            dataIndex: 'equivalencia',
            xtype: 'numbercolumn', format:'0.00'
        }, {
            text: 'Precio',
            width: 90,
            dataIndex: 'precio'
        },{
            text: 'Base',
            dataIndex: 'base',
            width: 90,
            align: 'center',
            renderer: function(val){
                if(val)
                    return '<span style="background:#26B99A;font-size: 75%;border-radius: .25em; color:white; padding: .1em .6em .1em; text-align: center;"> Base </span>';
            }
        }],
    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Asignar',
                    bind: {
                        disabled: '{selectMaterialUnidad}'
                    },
                    handler: 'addMaterialUnidad'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Quitar',
                    bind: {
                        disabled: '{!selectMaterialUnidad}'
                    },
                    handler: 'deleteMaterialUnidad'
                }]
        }]
});
