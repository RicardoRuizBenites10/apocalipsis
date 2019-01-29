Ext.define('GrupoBruce.view.contrato.FormContratoFinalizar', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformContratoFinalizar',
    reference: 'form_contratoFinalizar',

    viewModel: {
        type: 'VMcontratoTrabajador'
    },
    controller: 'CcontratoTrabajador',

    width: 400,
    resizable: false,
    closable: false,
    modal: true,
    autoShow: true,
    title: 'Finalizar contrato',
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
                            xtype: 'datefield',
                            name: 'fechaCese',
                            fieldLabel: 'Último dia de trabajo'
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'motivoCese',
                            fieldLabel: 'Motivo',
                            allowBlank: true,
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
                        click: 'onFinalizaContrato'
                    }
                }]
        }]
});