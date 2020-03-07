Ext.define('GrupoBruce.view.requerimientomaterial.RequerimientoMaterial', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.requerimientomaterial.RequerimientoMaterialController',
        'GrupoBruce.view.requerimientomaterial.RequerimientoMaterialModel',

        'GrupoBruce.view.requerimientomaterial.ListRequerimientoMaterial'
    ],

    controller: 'requerimientomaterial-requerimientomaterial',
    viewModel: {
        type: 'requerimientomaterial-requerimientomaterial'
    },

    modal: true,
    autoShow: true,
    resizable: false,
    width: 600,

    title: 'Requerimiento de materiales',
    items: [{
            defaults: {
                layout: 'hbox',
                defaults: {
                    labelAlign: 'top',
                    padding: 7
                }
            },
            items: [{
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Actividad a realizar',
                            bind: {
                                value: '{recordRequerimiento.actividad}'
                            },
                            readOnly: true,
                            flex: 1
                        }, {
                            xtype: 'datefield',
                            fieldLabel: 'Fecha a realizar',
                            bind: {
                                value: '{recordRequerimiento.fechaProgramado}'
                            },
                            readOnly: true
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Trabajo que realizara actividad',
                            bind: {
                                value: '{recordRequerimiento.trabajador}'
                            },
                            readOnly: true,
                            flex: 1
                        }]
                }]
        }, {
            xtype: 'Wlistrequerimientomaterial',
            height: 300
        }]
});
