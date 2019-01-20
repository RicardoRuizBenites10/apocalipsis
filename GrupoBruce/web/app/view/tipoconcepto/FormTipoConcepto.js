Ext.define('GrupoBruce.view.tipoconcepto.FormTipoConcepto', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformTipoConcepto',
    reference: 'form_tipoConcepto',

    controller: 'Ctipoconcepto',
    viewModel: {
        type: 'VMtipoconcepto'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar tipo concepto',
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
                            xtype: 'textfield',
                            name: 'descripcion',
                            fieldLabel: 'Nombre',
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
                        click: 'onSaveTipoConcepto'
                    }
                }]
        }]
});