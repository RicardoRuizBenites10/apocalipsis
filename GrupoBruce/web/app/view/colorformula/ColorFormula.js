Ext.define('GrupoBruce.view.colorformula.ColorFormula',{
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wcolorformula',
    reference: 'color_formula',
    id: 'id_wcolorformula',

    requires: [
        'GrupoBruce.view.colorformula.ColorFormulaController',
        'GrupoBruce.view.colorformula.ColorFormulaModel',
        
        'GrupoBruce.view.colorformula.FormColorFormula'
    ],

    controller: 'Ccolorformula',
    viewModel: {
        type: 'VMcolorformula'
    },

    bind: {
        store: '{colorformulas}',
        selection: '{selectColorFormula}'
    },
    allowDeselect: true,
    height: 300,
    
    columns: [{
            text: 'Material',
            dataIndex: 'material',
            width: 250
    },{
        text: 'Cantidad',
        dataIndex: 'cantidad'
    }],

    dockedItems: [{
            xtype: 'toolbar',
            overflowHandler: 'menu',
            items: [{
                    iconCls: 'x-fa fa-plus',
                    text: 'Agregar',
                    bind: {
                        disabled: '{selectColorFormula}'
                    },
                    handler: 'addColorFormula'
                }, {
                    iconCls: 'x-fa fa-trash',
                    disabled: true,
                    text: 'Quitar',
                    bind: {
                        disabled: '{!selectColorFormula}'
                    },
                    handler: 'deleteColorFormula'
                }]
        }]
});
