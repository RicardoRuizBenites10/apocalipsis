Ext.define('GrupoBruce.view.carroceria.FormCarroceria', {
    extend: 'Ext.window.Window',
    alias: 'widget.Wformcarroceria',
    reference: 'form_carroceria',
    id: 'id_wformcarroceria',

    controller: 'Ccarroceria',
    viewModel: 'VMcarroceria',

    width: 400,
    modal: true,
    closable: false,
    resizable: false,
    autoShow: true,

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
//                            listeners: {
//                                change: 'onChangeCodigo'
//                            },
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
//                            listeners: {
//                                change: 'onChangeCodigo'
//                            },
                            flex: 1
                        }]
                }, {
                    items: [{
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
//                            listeners: {
//                                change: 'onChangeCodigo'
//                            },
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
                            xtype: 'textfield',
                            fieldLabel: 'Código',
                            name: 'idCarroceria',
                            bind: '{codigoLetra}',
                            editable: false,
                            flex: 1
                        }]
                }, {
                    items: [{
                            xtype: 'textarea',
                            fieldLabel: 'Descripción',
                            name: 'descripcion',
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
                        click: 'onSaveCarroceria'
                    }
                }]
        }]
});