Ext.define('GrupoBruce.view.requerimientomaterial.ListRequerimientoMaterial', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistrequerimientomaterial',
    reference: 'list_requerimientomaterial',
    id: 'id_wlistrequerimientomaterial',

    bind: {
        store: '{requermientomaterials}',
        selection: '{selectRequerimientoMaterial}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Código'
        }, {
            text: 'Material'
        }, {
            text: 'Unidad'
        }, {
            text: 'Estandar'
        }, {
            text: 'Requerido'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            overflowHandler: 'menu',
            items: [{
                    text: 'Agregar',
                    iconCls: 'x-fa fa-plus'
                }, {
                    text: 'Quitar',
                    iconCls: 'x-fa fa-trash'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{requerimientomaterials}'
            }
        }]

});