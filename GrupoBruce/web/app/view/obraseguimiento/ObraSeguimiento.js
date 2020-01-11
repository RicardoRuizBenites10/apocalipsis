Ext.define('GrupoBruce.view.obraseguimiento.ObraSeguimiento', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.obraseguimiento.ObraSeguimientoController',
        'GrupoBruce.view.obraseguimiento.ObraSeguimientoModel',

        'GrupoBruce.view.obraseguimiento.ListObraSeguimiento'
    ],

    controller: 'Cobraseguimiento',
    viewModel: {
        type: 'VMobraseguimiento'
    },

    modal: true,
    resizable: false,
    closable: false,
    autoShow: true,

    width: 600,
    height: 400,

    item: [{
            xtype: 'form',
            items: [{
                    defaults: {
                        layout: 'hbox',
                        defaults: {
                            allowBlank: false,
                            labelAlign: 'top',
                            padding: 7,
                            flex: 1
                        }
                    },
                    items: [{
                            items: [{
                                    xtype: 'textfield',
                                    name: 'nombre',
                                    fieldLabel: 'Orden de producción',
                                    bind: {
                                        value: '{recordObra.nombre}'
                                    },
                                    editable: false
                                }, {
                                    xtype: 'checkbox',
                                    name: 'gopintura',
                                    reference: 'chk_gopintura',
                                    fieldLabel: 'GO Pintura',
                                    boxLabel: 'Aprobado'
                                }]
                        }]
                }, {
                    xtype: 'Wlistobraseguimienti',
                    height: 280
                }]
        }]
});
