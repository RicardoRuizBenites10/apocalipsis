Ext.define('GrupoBruce.view.proformadetalle.ProformaDetalle', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wproformadetalle',
    reference: 'proforma_detalle',
    id: 'id_wproformadetalle',

    requires: [
        'GrupoBruce.view.proformadetalle.ProformaDetalleController',
        'GrupoBruce.view.proformadetalle.ProformaDetalleModel'
    ],

    controller: 'Cproformadetalle',
    viewModel: {
        type: 'VMproformadetalle'
    },

    bind: {
        store: '{proformadetalles}',
        selection: '{selectProformaDetalle}'
    },
    allowDeselect: true,

    columns: [{
            text: 'Categoría'
        }, {
            text: 'Especificación'
        }, {
            text: 'Estandar'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    text: 'Adicionar',
                    iconCls: 'x-fa fa-plus',
                    handler: 'addProformaDetalle'
                }, {
                    text: 'Quitar',
                    iconCls: 'x-fa fa-trash',
                    handler: 'deleteProformaDetalle'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{proformadetalles}'
            },
            displayInfo: true
        }]
});
