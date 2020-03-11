Ext.define('GrupoBruce.view.requerimientomaterial.ListRequerimientoMaterial', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistrequerimientomaterial',
    reference: 'list_requerimientomaterial',
    id: 'id_wlistrequerimientomaterial',

    bind: {
        store: '{requerimientomaterials}',
        selection: '{selectRequerimientoMaterial}'
    },
    allowDeselect: true,
  
    plugins: {
        ptype: 'cellediting',
        clicksToEdit: 1
    },

    columns: [{
            text: 'Material',
            dataIndex: 'material',
            width: 300
        }, {
            text: 'Estandar',
            dataIndex: 'estandar'
        }, {
            text: 'Unidad',
            dataIndex: 'idUmedida'
        }, {
            text: 'Pedir',
            dataIndex: 'requerido',
            editor: {
                xtype: 'numberfield',
                allowBlank: false,
                minValue: 0,
                maxValue: 100000
            }
        }, {
            text: 'Momento actual',
            columns: [{
                    text: 'Stock',
                    dataIndex: 'stock'
                }, {
                    text: 'Requerido',
                    dataIndex: 'requeridot'
                }, {
                    text: 'Despachado',
                    dataIndex: 'despachadot'
                }]
        }],

    dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            overflowHandler: 'menu',
            items: [{
                    text: 'Agregar',
                    iconCls: 'x-fa fa-plus',
                    handler: 'addMaterial'
                }, {
                    text: 'Quitar',
                    iconCls: 'x-fa fa-trash',
                    bind: {
                        disabled: '{!selectRequerimientoMaterial}'
                    },
                    handler: 'deleteMaterial'
                }]
        }]

});