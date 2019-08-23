Ext.define('GrupoBruce.view.sucursal.FormSucursal', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wsucursal',
    reference: 'form_sucursal',

    controller: 'Csucursal',
    viewModel: {
        type: 'VMsucursal'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 400,

    title: 'Editar sucursal',
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
                            fieldLabel: 'Descripción',
                            name: 'descripcion',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            name: 'direccion',
                            fieldLabel: 'Dirección',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'telefono',
                            fieldLabel: 'Teléfono',
                            allowBlank: true,
                            flex: 1
                        }, {
                            xtype: 'textfield',
                            name: 'telefono2',
                            allowBlank: true,
                            fieldLabel: 'Teléfono 2',
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
                        click: 'onSaveSucursal'
                    }
                }]
        }]
});