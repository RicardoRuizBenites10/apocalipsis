Ext.define('GrupoBruce.view.trabajador.FormTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.wformTrabajador',
    reference: 'form_trabajador',

    controller: 'Ctrabajador',

    height: 575,
    width: 550,
    resizable: false,
    modal: true,
    closable: false,
    autoShow: true,

    items: [{
            xtype: 'form',
            reference: 'form_trabajador',
            items: [{
                    xtype: 'tabpanel',
                    border: false,
                    defaults: {
                        bodyPadding: 4,
                        scrollable: true,
                        border: false
                    },
                    items: [{
                            title: 'Información personal',
                            iconCls: 'fa fa-user',
                            items: [{
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
                                                    name: 'idNacionalidad',
                                                    fieldLabel: 'Nacionalidad:',
                                                    displayField: 'descripcion',
                                                    valueField: 'idNacionalidad',
                                                    store: {
                                                        type: 'Snacionalidad',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idTdocumento',
                                                    fieldLabel: 'Tipo documento:',
                                                    displayField: 'descripcionAbreviada',
                                                    valueField: 'idTdocumento',
                                                    store: {
                                                        type: 'StipoDocumento',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'idTrabajador',
                                                    fieldLabel: 'Número DNI:'
                                                }]
                                        }, {
                                            items: [
                                                {
                                                    xtype: 'textfield',
                                                    name: 'apPaterno',
                                                    fieldLabel: 'Apellido Paterno'
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'apMaterno',
                                                    fieldLabel: 'Apellido Materno'
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'nombres',
                                                    fieldLabel: 'Nombres'
                                                }
                                            ]
                                        }, {
                                            items: [
                                                {
                                                    xtype: 'combobox',
                                                    name: 'idGenero',
                                                    fieldLabel: 'Genero :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idGenero',
                                                    store: {
                                                        type: 'Sgenero',
                                                        autoLoad: true
                                                    }

                                                }, {
                                                    xtype: 'datefield',
                                                    name: 'nacimiento',
                                                    fieldLabel: 'Fecha nacimiento :',
                                                    format: 'd/m/Y'
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idEcivil',
                                                    fieldLabel: 'Estado civil :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idEcivil',
                                                    store: {
                                                        type: 'Secivil',
                                                        autoLoad: true
                                                    }
                                                }
                                            ]
                                        }, {
                                            items: [
                                                {
                                                    xtype: 'numberfield',
                                                    allowDecimals: false,
                                                    hideTrigger: true,
                                                    minValue: 0,
                                                    maxValue: 8,
                                                    name: 'nroHijos',
                                                    fieldLabel: 'Número hijos :'
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'telefono',
                                                    fieldLabel: 'Teléfono :'
                                                }
                                            ]
                                        }, {
                                            items: [{
                                                    xtype: 'textfield',
                                                    name: 'referencia',
                                                    fieldLabel: 'Referencia :',
                                                    flex: 3
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'textfield',
                                                    name: 'direccion',
                                                    fieldLabel: 'Dirección :',
                                                    flex: 3
                                                }]
                                        }]
                                }]
                        }, {
                            title: 'Datos laborales',
                            iconCls: 'fa fa-file-text',
                            items: [{
                                    defaults: {
                                        xtype: 'container',
                                        layout: 'hbox',
                                        defaults: {
                                            labelAlign: 'top',
                                            padding: 5
                                        }
                                    },

                                    items: [{
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idEtrabajador',
                                                    fieldLabel: 'Situación trabajador :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idEtrabajador',
                                                    store: {
                                                        type: 'SestadoTrabajador',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idTtrabajador',
                                                    fieldLabel: 'Tipo trabajador :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idTtrabajador',
                                                    store: {
                                                        type: 'StipoTrabajador',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'codigo',
                                                    fieldLabel: 'Codigo trabajador :'
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idEfCts',
                                                    fieldLabel: 'Banco CTS :',
                                                    displayField: 'nombre',
                                                    valueField: 'idEfinanciera',
                                                    store: {
                                                        type: 'SentidadFinanciera',
                                                        autoLoad: true
                                                    },
                                                    bind: {
                                                        hidden: '{hasctacts}'
                                                    }
//                                                    hidden: true
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'nrocuentaCts',
                                                    fieldLabel: 'Cuenta CTS :'
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idFpago',
                                                    fieldLabel: 'Forma Pago :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idFpago',
                                                    store: {
                                                        type: 'SformaPago',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idPeriocidad',
                                                    fieldLabel: 'Periocidad de Pago :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idPeriocidad',
                                                    store: {
                                                        type: 'Speriocidad',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'numberfield',
                                                    name: 'montoPasaje',
                                                    hideTrigger: true,
                                                    minValue: 0,
                                                    fieldLabel: 'Monto pasaje :'
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idEfSueldo',
                                                    fieldLabel: 'Banco sueldo :',
                                                    displayField: 'nombre',
                                                    valueField: 'idEfinanciera',
                                                    store: {
                                                        type: 'SentidadFinanciera',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'nrocuentaSueldo',
                                                    fieldLabel: 'Cuenta sueldo :'
                                                }, {
                                                    xtype: 'numberfield',
                                                    allowDecimals: true,
                                                    hideTrigger: true,
                                                    minValue: 0,
                                                    name: 'montoBase',
                                                    fieldLabel: 'Monto sueldo :'
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idRpensionario',
                                                    fieldLabel: 'Regimen pensionario :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idRpensionario',
                                                    reference: 'cboRPensionario',
                                                    publishes: ['value'],
                                                    store: {
                                                        type: 'SregimenPensionario',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idComisionrp',
                                                    fieldLabel: 'Comisión :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idComisionrp',
                                                    forceSelection: true,
                                                    bind: {
                                                        filters: {
                                                            property: 'idRpensionario',
                                                            value: '{cboRPensionario.value}'
                                                        }
                                                    },
                                                    store: {
                                                        type: 'Scomisionrp',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'nrocusppAfiliacion',
                                                    fieldLabel: 'Nro CUSPP :'
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idEmpresa',
                                                    fieldLabel: 'Empresa :',
                                                    displayField: 'descripcion',
                                                    valueField: 'idEmpresa',
                                                    forceSelection: true,
                                                    reference: 'cboEmpresa',
                                                    publishes: 'value',
                                                    store: {
                                                        type: 'Sempresa',
                                                        autoLoad: true
                                                    }
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idSucursal',
                                                    displayField: 'direccion',
                                                    valueField: 'idSucursal',
                                                    fieldLabel: 'Lugar de trabajo :',
                                                    flex: 2,
                                                    bind: {
                                                        filters: {
                                                            property: 'idEmpresa',
                                                            value: '{cboEmpresa.value}'
                                                        }
                                                    },
                                                    store: {
                                                        type: 'Ssucursal',
                                                        autoLoad: true
                                                    }
                                                }]
                                        }]
                                }]
                        }]
                }],

            buttons: [{
                    text: 'Cancelar',
                    listeners: {
                        click: function () {
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
                        click: 'onSaveTrabajador'
                    }
                }]
        }]


});