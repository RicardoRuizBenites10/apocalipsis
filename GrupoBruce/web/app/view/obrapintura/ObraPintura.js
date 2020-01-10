Ext.define('GrupoBruce.view.obrapintura.ObraPintura', {
    extend: 'Ext.window.Window',

    requires: [
        'GrupoBruce.view.obrapintura.ObraPinturaController',
        'GrupoBruce.view.obrapintura.ObraPinturaModel',

        'GrupoBruce.view.obrapintura.ListObraPintura',
        'GrupoBruce.view.obrapintura.FormObraPintura'
    ],

    controller: 'Cobrapintura',
    viewModel: {
        type: 'VMobrapintura'
    },

    modal: true,
    autoShow: true,
    resizable: false,
    width: 600,

    title: 'Colores de Orden de Producción',
    items: [{
            xtype: 'form',
            padding: 7,
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
                                }, {
                                    xtype: 'datefield',
                                    name: 'gopinturafecha',
                                    fieldLabel: 'Fecha GO Pintura'
                                }]
                        }]
                }, {
                    xtype: 'fieldset',
                    title: 'Colores asignados',
                    items: [{
                            xtype: 'Wlistobrapintura',
                            height: 200
                        }]
                }],

            buttons: [{
                    text: 'Cancelar',
                    listeners: {
                        click: function () {
                            this.up('form').reset();
                            this.up('window').close();
                        }
                    }
                }, {
                    text: 'Restablecer',
                    listeners: {
                        click: function () {
                            this.up('form').reset();
                        }
                    }
                }, {
                    text: 'Grabar',
                    iconCls: 'fa fa-save',
                    formBind: true,
                    listeners: {
                        click: 'onSaveObra2'
                    }
                }]
        }]
});
