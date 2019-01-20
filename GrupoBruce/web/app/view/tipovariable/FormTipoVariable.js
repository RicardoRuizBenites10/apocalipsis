Ext.define('GrupoBruce.view.tipovariable.FormTipoVariable', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformTipoVariable',
    reference: 'form_tipoVariable',

    controller: 'Ctipovariable',
    viewModel: {
        type: 'VMtipovariable'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar tipo variable',
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
                        click: 'onSaveTipoVariable'
                    }
                }]
        }]
});