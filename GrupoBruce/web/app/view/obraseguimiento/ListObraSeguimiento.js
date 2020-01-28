Ext.define('GrupoBruce.view.obraseguimiento.ListObraSeguimiento', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistobraseguimiento',
    reference: 'list_obraseguimiento',
    id: 'id_wlistobraseguimiento',
    
    
    selModel: {
        type: 'cellmodel'
    },

    plugins: {
        ptype: 'cellediting',
        clicksToEdit: 2
    },

    bind: {
        store: '{obraseguimientos}',
        selection: '{selectObraSeguimiento}'
    },
//    allowDeselect: true,

    columns: [{
            text: 'Área',
            dataIndex: 'etapa'
        }, {
            text: 'Programación',
            columns: [{
                    text: 'Inicio',
                    dataIndex: 'inicioProgramado',
                    formatter: 'date("d/m/Y")',
                    editor: {
                        xtype: 'datefield',
                        format: 'd/m/Y',
                        minValue: '01/01/06',
                        disabledDays: [0],
                        disabledDaysText: 'Día no laborable'
                    }
                }, {
                    text: 'Fin',
                    dataIndex: 'finProgramado',
                    formatter: 'date("d/m/Y")',
                    editor: {
                        xtype: 'datefield',
                        format: 'd/m/Y',
                        minValue: '01/01/06',
                        disabledDays: [0],
                        disabledDaysText: 'Día no laborable'
                    }
                }]
        }, {
            text: 'Ejecución',
            columns: [{
                    text: 'Inicio'
                }, {
                    text: 'Fin'
                }]
        }, {
            text: 'Ubicación',
            dataIndex: 'ubicacion',
            xtype: 'checkcolumn'
        }],

    listeners: {
        cellclick: 'onSelectionChange'
    }
    
});