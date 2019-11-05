Ext.define('GrupoBruce.view.proformadetalle.ProformaDetalle', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wproformadetalle',
    reference: 'proforma_detalle',
    id: 'id_wproformadetalle',

    requires: [
        'GrupoBruce.view.proformadetalle.ProformaDetalleController',
        'GrupoBruce.view.proformadetalle.ProformaDetalleModel',
        
        'GrupoBruce.view.proformadetalle.FormProformaDetalle'
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
            text: 'Categoría',
            dataIndex: 'categoria',
            align: 'left'
        }, {
            text: 'Especificación',
            dataIndex: 'especificacion',
            width: 380
        }, {
            text: 'Estandar',
            dataIndex: 'wasstd',
            renderer: function (val) {
                var icon;
                if(val){
                    icon = '<i class="fa fa-check-square"></i>';
                }else{
                    icon = '<i class="fa fa-square-o"></i>';
                }
                return icon;
            },
            align: 'center'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    text: 'Adicionar',
                    iconCls: 'x-fa fa-plus',
                    bind: {
                      disabled: '{!recordCarroceria}'
                    },
                    handler: 'addProformaDetalle'
                }, {
                    text: 'Quitar',
                    iconCls: 'x-fa fa-trash',
                    bind: {
                      disabled: '{!selectProformaDetalle}'  
                    },
                    handler: 'deleteProformaDetalle'
                }]
        }]
});
