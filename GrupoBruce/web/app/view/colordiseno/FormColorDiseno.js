Ext.define('GrupoBruce.view.colordiseno.FormColorDiseno', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformcolordiseno',
    reference: 'form_colordiseno',
    id: 'id_wformcolordiseno',

    requires: [
        'GrupoBruce.view.colorformula.ColorFormula'
    ],

    controller: 'Ccolordiseno',
    viewModel: {
        type: 'VMcolordiseno'
    },

    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,
    scrollable: true,
    width: 400,
    maxHeight: Ext.getBody().getViewSize().height * 0.8,

    title: 'Editar color diseño',
    items: [{
            xtype: 'form',
            minHeight: 400,
            items: [{
                    xtype: 'tabpanel',
                    items: [{
                            title: 'Datos generales',
                            defaults: {
                                layout: 'hbox',
                                defaults: {
                                    labelAlign: 'top',
                                    padding: 7,
                                    allowBlank: false
                                }
                            },
                            items: [{
                                    items: [{
                                            xtype: 'textfield',
                                            name: 'idCdiseno',
                                            fieldLabel: 'Código de color',
                                            bind: '{idCdiseno}',
                                            maxSize: 8,
                                            flex: 1
                                        }]
                                }, {
                                    items: [{
                                            xtype: 'textfield',
                                            name: 'denominacion',
                                            fieldLabel: 'Denominación',
                                            flex: 1
                                        }]
                                }]
                        }, {
                            title: 'Fórmulas',
                            items: [{
                                    xtype: 'Wcolorformula'
                                }]
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
                        click: 'onSaveColorDiseno'
                    }
                }]
        }]
});