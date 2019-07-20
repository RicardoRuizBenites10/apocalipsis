Ext.define('GrupoBruce.view.proveedor.FormProveedor', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformproveedor',
    reference: 'form_proveedor',
    id: 'id_wformproveedor',

    controller: 'Cproveedor',
    viewModel: {
        type: 'VMproveedor'
    },

    modal: true,
    closable: false,
    resizable: false,
    width: 500,
    title: 'Editar proveedor',

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
                            xtype: 'numberfield',
                            name: 'idProveedor',
                            fieldLabel: 'Nro. RUC',
                            hideTrigger: true,
                            minLength: 8,
                            maxLength: 15,
                            bind: {
                                editable: '{newRegister}'
                            },
                            width: '48%'
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'nombre',
                            fieldLabel: 'Nombre',
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'direccion',
                            fieldLabel: 'Dirección',
                            flex: 1,
                            allowBlank: true
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
                            name: 'correo',
                            fieldLabel: 'Correo electronico',
                            allowBlank: true,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textfield',
                            name: 'ccorriente1',
                            fieldLabel: 'Cuenta 1',
                            allowBlank: true,
                            flex: 1
                        }, {
                            xtype: 'textfield',
                            name: 'ccorriente2',
                            fieldLabel: 'Cuenta 2',
                            allowBlank: true,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'checkbox',
                            name: 'situacion',
                            reference: 'chk_situacionproveedor',
                            fieldLabel: 'Situación',
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
                        click: 'onSaveProveedor'
                    }
                }]
        }]
});