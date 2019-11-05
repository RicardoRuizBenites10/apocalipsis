Ext.define('GrupoBruce.view.proforma.FormProforma', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformproforma',
    reference: 'form_proforma',
    id: 'id_wformproforma',

    requires: [
        'GrupoBruce.view.proformadetalle.ProformaDetalle'
    ],

    controller: 'Cproforma',
    viewModel: {
        type: 'VMproforma'
    },

    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,
    width: 600,

    title: 'Editar proforma cliente',
    items: [{
            xtype: 'form',
            items: [{
                    xtype: 'tabpanel',
                    minHeight: 400,
                    items: [{
                            defaults: {
                                layout: 'hbox',
                                defaults: {
                                    padding: 10,
                                    allowBlank: false,
                                    labelAlign: 'top'
                                }
                            },
                            title: 'Datos generales',
                            items: [{
                                    items: [{
                                            xtype: 'textfield',
                                            fieldLabel: 'Código proforma',
                                            name: 'idProforma',
                                            readOnly: true
                                        }, {
                                            xtype: 'combobox',
                                            fieldLabel: 'Cliente',
                                            name: 'idCliente',
                                            displayField: 'nombre',
                                            valueField: 'idCliente',
                                            bind: {
                                                store: '{clientes}',
                                                selection: '{selectCliente}'
                                            },
                                            emptyText: 'Seleccionar',
                                            hideTrigger: true,
                                            forceSelection: true,
                                            minChars: 3,
                                            pageSize: true,
                                            triggerAction: 'query',
                                            flex: 1
                                        }]
                                },
                                {
                                    layout: 'fit',
                                    padding: '0 10 0 10',
                                    items: [{
                                            xtype: 'fieldset',
                                            title: 'Modelo de carrocería',
                                            defaults: {
                                                layout: 'hbox',
                                                defaults: {
                                                    padding: 7,
                                                    allowBlank: false,
                                                    labelAlign: 'top'
                                                }
                                            },
                                            items: [{
                                                    items: [{
                                                            xtype: 'combobox',
                                                            fieldLabel: 'Tipo de carroceria',
                                                            name: 'idCarmod',
                                                            valueField: 'idCarmod',
                                                            displayField: 'nombre',
                                                            bind: {
                                                                store: '{carroceriamodelos}',
                                                                selection: '{selectCarroceriaModelo}'
                                                            },
                                                            emptyText: 'Seleccionar',
                                                            forceSelection: true,
                                                            editable: false,
                                                            flex: 1
                                                        }, {
                                                            xtype: 'combobox',
                                                            fieldLabel: 'Subtipo de carroceria',
                                                            name: 'idCartip',
                                                            valueField: 'idCartip',
                                                            displayField: 'nombre',
                                                            bind: {
                                                                store: '{carroceriatipos}',
                                                                selection: '{selectCarroceriaTipo}'
                                                            },
                                                            emptyText: 'Seleccionar',
                                                            forceSelection: true,
                                                            editable: false,
                                                            flex: 1
                                                        },{
                                                            xtype: 'combobox',
                                                            fieldLabel: 'Falda de carroceria',
                                                            name: 'idCarfal',
                                                            valueField: 'idCarfal',
                                                            displayField: 'nombre',
                                                            bind: {
                                                                store: '{carroceriafaldas}',
                                                                selection: '{selectCarroceriaFalda}'
                                                            },
                                                            emptyText: 'Seleccionar',
                                                            editable: false,
                                                            flex: 1
                                                        }]
                                                }, {
                                                    items: [{
                                                            xtype: 'combobox',
                                                            fieldLabel: 'Proveedor de chasis',
                                                            name: 'idChapro',
                                                            valueField: 'idChapro',
                                                            displayField: 'nombre',
                                                            bind: {
                                                                store: '{chasisproveedors}',
                                                                selection: '{selectChasisProveedor}'
                                                            },
                                                            emptyText: 'Seleccionar',
                                                            editable: false,
                                                            flex: 1
                                                        }, {
                                                            xtype: 'combobox',
                                                            fieldLabel: 'Chasis',
                                                            name: 'idChasis',
                                                            valueField: 'idChasis',
                                                            displayField: 'modelo',
                                                            bind: {
                                                                store: '{chasiss}',
                                                                selection: '{selectChasis}'
                                                            },
                                                            emptyText: 'Seleccionar',
                                                            editable: false,
                                                            flex: 1
                                                        }]
                                                }, {
                                                    items: [{
                                                            xtype: 'combobox',
                                                            fieldLabel: 'Modelo carrocería',
                                                            name: 'idCarroceria',
                                                            valueField: 'idCarroceria',
                                                            displayField: 'descripcion',
                                                            bind: {
                                                                store: '{carrocerias}',
                                                                selection: '{selectCarroceria}'
                                                            },
                                                            emptyText: 'Seleccionar',
                                                            forceSelection: true,
                                                            editable: false,
                                                            flex: 1,
                                                            listeners: {
                                                                change: 'onChangeCarroceria'
                                                            }
                                                        }]
                                                }]
                                        }]
                                }]
                        }, {
                            title: 'Lista de especificaciones',
                            items: [{
                                    xtype: 'Wproformadetalle',
                                    height: 350
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
                        click: 'onSaveCliente'
                    }
                }]
        }]
});