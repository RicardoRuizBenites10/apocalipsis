Ext.define('GrupoBruce.view.requerimientoactividad.ListRequerimientoActividad', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.Wlistrequerimientoactividad',
    reference: 'list_requerimientoactividad',
    id: 'id_wlistrequerimientoactividad',

    selModel: {
        type: 'checkboxmodel',
        checkOnly: false
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
            dataIndex: 'estado',
            width: 170,
            renderer: function (val) {
                var texto;
                switch (val) {
                    case 'S':
                        texto='Generado';
                        break;
                    case 'C':
                        texto='Desp. conforme';
                        break;
                    case 'I':
                        texto='Desp. inconforme';
                        break;
                    default:
                        texto='No generado';
                }
                return texto;
            }
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
                    },
                    handler: 'onGenerarRequerimientos'
                }]
        }, {
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            bind: {
                store: '{requerimientoactividads}'
            }
        }]
});