Ext.define('GrupoBruce.view.cliente.FormCliente', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformcliente',
    reference: 'form_cliente',
    id: 'id_wformcliente',

    controller: 'Ccliente',
    viewModel: {
        type: 'VMcliente'
    },

    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,
    width: 400,

    title: 'Editar cliente',
    items: [{
            xtype: 'form',
            defaults: {
                layout: 'hbox',
                defaults: {
                    allowBlank: false,
                    labelAlign: 'top',
                    padding: 7
                }
            },
            items: [{
                    items: [{
                            xtype: 'numberfield',
                            fieldLabel: 'DNI o RUC',
                            name: 'idCliente',
                            hideTrigger: true,
                            bind: {
                                editable: '{newRecord}'
                            }
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Nombre',
                            name: 'nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            fieldLabel: 'Teléfono',
                            name: 'telefono',
                            flex: 1
                        }, {
                            xtype: 'textfield',
                            fieldLabel: 'Correo',
                            name: 'correo',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            fieldLabel: 'Dirección',
                            name: 'direccion',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'situacion',
                            reference: 'chk_situacioncliente',
                            fieldLabel: 'Situacion',
                            boxLabel: 'Activo'
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
                        click: 'onSaveCliente'
                    }
                }]
        }]
});