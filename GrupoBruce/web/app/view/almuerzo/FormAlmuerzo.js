Ext.define('GrupoBruce.view.almuerzo.FormAlmuerzo', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformAlmuerzo',
    reference: 'form_almuerzo',

    controller: 'Calmuerzo',
    viewModel: {
        type: 'VMalmuerzo'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar almuerzo',
    items: [{
            xtype: 'form',
            defaults: {
                xtype: 'container',
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 5
                }
            },
            items: [{
                    items: [{
                            xtype: 'checkbox',
                            name: 'refrigerio',
                            reference: 'chk_refrigerio',
                            fieldLabel: 'Refrigerio',
                            boxLabel: 'Hizo uso de tiempo de refrigerio',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'enComedor',
                            reference: 'chk_encomedor',
                            fieldLabel: 'Almuerzo',
                            boxLabel: 'Hizo uso de consesionario',
                            flex: 1
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
                        click: 'onSaveAlmuerzo'
                    }
                }]
        }]
});