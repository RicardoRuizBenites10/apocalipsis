Ext.define('GrupoBruce.view.actividadmaterial.ActividadMaterial', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wactividadmaterial',
    reference: 'actidad_material',
    id: 'id_wactividadmaterial',

    requires: [
        'GrupoBruce.view.actividadmaterial.ActividadMaterialController',
        'GrupoBruce.view.actividadmaterial.ActividadMaterialModel',
        
        'GrupoBruce.view.actividadmaterial.FormActividadMaterial'
    ],

    controller: 'Cactividadmaterial',
    viewModel: {
        type: 'VMactividadmaterial'
    },

    bind: {
        store: '{actividadmaterials}',
        selection: '{selectActividadMaterial}'
    },
    allowDeselect: true,
    height: 300,

    columns: [{
            text: 'Nombre',
            dataIndex: 'material',
            align: 'left',
            width: 200
        }, {
            text: 'U.Medida',
            dataIndex: 'idUmedida',
            align: 'left',
            width: 90
        }, {
            text: 'Cantidad',
            dataIndex: 'cantidad',
            width: 90
        }],
    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Agregar',
                    bind: {
                        disabled: '{selectActividadMaterial}'
                    },
                    handler: 'addActividadMaterial'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Quitar',
                    bind: {
                        disabled: '{!selectActividadMaterial}'
                    },
                    handler: 'deleteActividadMaterial'
                }]
        }]
});
