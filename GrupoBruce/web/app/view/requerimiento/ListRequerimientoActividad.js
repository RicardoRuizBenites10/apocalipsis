Ext.define('GrupoBruce.view.requerimiento.ListRequerimientoActividad', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistrequerimientoactividad',
    reference: 'list_requerimientoactividad',
    id: 'id_wlistrequerimientoactividad',

    selModel: {
        type: 'checkboxmodel',
        checkOnly: true
    },
    bind: {
        store: '{requerimientoactividads}',
        selection: '{selectRequerimientoActividad}'
    },
    allowDeselect: true,
    
    columns: [{
            text: 'Actividad',
            dataIndex: 'actividad',
            width: 390
        }, {
            text: 'Situación',
            dataIndex: 'estado'
        }, {
            text: 'Tareo'
        }],

    dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                    xtype: 'textfield'
                }, {
                    text: 'Generar vale',
                    bind: {
                        disabled: '{!selectRequerimientoActividad}'
                    }
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{requerimientoactividads}'
            }
        }]
});