Ext.define('GrupoBruce.view.trabajador.FormTrabajador', {
    extend: 'Ext.window.Window',
    alias: 'widget.WformTrabajador',

    viewModel: {
        type: 'VMformTrabajador'
    },
    controller: 'Ctrabajador',

//    height: 575,
    width: 550,
    resizable: false,
    modal: true,
    closable: false,
    autoShow: true,

    items: [{
            xtype: 'form',
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
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idNacionalidad',
                                                    bind: {
                                                        store: '{nacionalidads}'
                                                    }
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idTdocumento',
                                                    fieldLabel: 'Tipo documento:',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcionAbreviada',
                                                    valueField: 'idTdocumento',
                                                    bind: {
                                                        store: '{tipoDocumentos}'
                                                    }
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'idTrabajador',
                                                    fieldLabel: 'Número documento:'
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
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idGenero',
                                                    bind: {
                                                        store: '{generos}'
                                                    }

                                                }, {
                                                    xtype: 'datefield',
                                                    name: 'nacimiento',
                                                    fieldLabel: 'Fecha nacimiento :',
                                                    maxValue: '01/01/2000',
                                                    format: 'd/m/Y'
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idEcivil',
                                                    fieldLabel: 'Estado civil :',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idEcivil',
                                                    bind: {
                                                        store: '{ecivils}'
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
                                                    allowBlank: true,
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
                            title: 'Formación educacional',
                            iconCls: 'fa fa-graduation-cap',
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
                                                    xtype: 'combo',
                                                    name: 'idTestudio',
                                                    fieldLabel: 'Nivel estudios',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idTestudio',
                                                    bind: {
                                                        store: '{tiposEstudio}'
                                                    },
                                                    flex: 1
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combo',
                                                    name: 'idEestudio',
                                                    fieldLabel: 'Estado estudios',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idEestudio',
                                                    bind: {
                                                        store: '{estadosEstudio}'
                                                    },
                                                    flex: 1
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'textfield',
                                                    name: 'institucion',
                                                    allowBlank: true,
                                                    fieldLabel: 'Institución',
                                                    flex: 1
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'textfield',
                                                    name: 'profesion',
                                                    allowBlank: true,
                                                    fieldLabel: 'Profesión',
                                                    flex: 1
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
                                            allowBlank: false,
                                            padding: 5
                                        }
                                    },
                                    items: [{
                                            items: [
                                                {
                                                    xtype: 'combobox',
                                                    name: 'idTtrabajador',
                                                    fieldLabel: 'Tipo trabajador :',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idTtrabajador',
                                                    bind: {
                                                        store: '{tipoTrabajadors}',
                                                        selection: '{selectTTrabajador}'
                                                    }
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'codigo',
                                                    fieldLabel: 'Codigo trabajador :',
                                                    allowBlank: true
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idEfCts',
                                                    fieldLabel: 'Banco CTS :',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'nombre',
                                                    valueField: 'idEfinanciera',
                                                    disabled: true,
                                                    bind: {
                                                        store: '{entidadFinancieras}',
                                                        disabled: '{!selectTTrabajador.hasctacts}'
                                                    },
                                                    listeners: {
                                                        disable: function () {
                                                            this.setValue('');
                                                            this.up('form').getRecord().set(this.name, this.value);
                                                        }
                                                    }
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'nrocuentaCts',
                                                    fieldLabel: 'Cuenta CTS :',
                                                    disabled: true,
                                                    bind: {
                                                        disabled: '{!selectTTrabajador.hasctacts}'
                                                    },
                                                    listeners: {
                                                        disable: function () {
                                                            this.setValue('');
                                                            this.up('form').getRecord().set(this.name, this.value);
                                                        }
                                                    }
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idFpago',
                                                    fieldLabel: 'Forma pago :',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idFpago',
                                                    bind: {
                                                        store: '{formaPagos}',
                                                        selection: '{selectFPago}'
                                                    },
                                                    flex: 1
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idPeriocidad',
                                                    fieldLabel: 'Periocidad de Pago :',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idPeriocidad',
                                                    bind: {
                                                        store: '{periocidads}'
                                                    },
                                                    flex: 1
                                                }, {
                                                    xtype: 'numberfield',
                                                    name: 'montoPasaje',
                                                    hideTrigger: true,
                                                    minValue: 0,
                                                    fieldLabel: 'Monto pasaje :',
                                                    flex: 1
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idEfSueldo',
                                                    fieldLabel: 'Banco sueldo :',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'nombre',
                                                    valueField: 'idEfinanciera',
                                                    disabled: true,
                                                    bind: {
                                                        store: '{entidadFinancieras}',
                                                        disabled: '{!selectFPago.hasnrocuenta}'
                                                    },
                                                    listeners: {
                                                        disable: function () {
                                                            this.setValue('');
                                                            this.up('form').getRecord().set(this.name, this.value);
                                                        }
                                                    },
                                                    flex: 1
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'nrocuentaSueldo',
                                                    fieldLabel: 'Cuenta sueldo :',
                                                    disabled: true,
                                                    bind: {
                                                        disabled: '{!selectFPago.hasnrocuenta}'
                                                    },
                                                    listeners: {
                                                        disable: function () {
                                                            this.setValue('');
                                                            this.up('form').getRecord().set(this.name, this.value);
                                                        }
                                                    },
                                                    flex: 1
                                                }, {
                                                    xtype: 'numberfield',
                                                    allowDecimals: true,
                                                    hideTrigger: true,
                                                    editable: false,
                                                    minValue: 0,
                                                    name: 'haberBasico',
                                                    fieldLabel: 'Monto sueldo :',
                                                    flex: 1
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idRpensionario',
                                                    fieldLabel: 'Regimen pensionario',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idRpensionario',
                                                    forceSelection: true,
                                                    disabled: true,
                                                    bind: {
                                                        store: '{regimenPensionarios}',
                                                        selection: '{selectRPensionario}',
                                                        disabled: '{!selectTTrabajador.hasctacts}'
                                                    },
                                                    listeners: {
                                                        disable: function () {
                                                            this.setValue('');
                                                            this.up('form').getRecord().set(this.name, this.value);
                                                        }
                                                    },
                                                    flex: 1
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idComisionrp',
                                                    fieldLabel: 'Comisión',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idComisionrp',
                                                    forceSelection: true,
                                                    disabled: true,
                                                    bind: {
                                                        store: '{comisionrps}',
                                                        disabled: ('{!selectRPensionario} ' && '{!selectRPensionario.cuspp}')
                                                    },
                                                    listeners: {
                                                        disable: function () {
                                                            this.setValue('');
                                                            this.up('form').getRecord().set(this.name, this.value);
                                                        }
                                                    },
                                                    flex: 1
                                                }, {
                                                    xtype: 'textfield',
                                                    name: 'nrocusppAfiliacion',
                                                    fieldLabel: 'Nro CUSPP :',
                                                    disabled: true,
                                                    flex: 1,
                                                    bind: {
                                                        disabled: ('{!selectRPensionario} ' && '{!selectRPensionario.cuspp}')
                                                    },
                                                    listeners: {
                                                        disable: function () {
                                                            this.setValue('');
                                                            this.up('form').getRecord().set(this.name, this.value);
                                                        }
                                                    }
                                                }]
                                        }, {
                                            items: [{
                                                    xtype: 'combobox',
                                                    name: 'idEmpresa',
                                                    fieldLabel: 'Empresa ',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'descripcion',
                                                    valueField: 'idEmpresa',
                                                    forceSelection: true,
                                                    bind: {
                                                        store: '{empresas}',
                                                        selection: '{selectEmpresa}'
                                                    },
                                                    flex: 1
                                                }, {
                                                    xtype: 'combobox',
                                                    name: 'idSucursal',
                                                    editable: false,
                                                    emptyText: 'Seleccionar',
                                                    displayField: 'direccion',
                                                    valueField: 'idSucursal',
                                                    fieldLabel: 'Sucursal',
                                                    forceSelection: true,
                                                    bind: {
                                                        store: '{sucursals}'
                                                    },
                                                    flex: 2
                                                }]
                                        }
                                    ]
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
                        click: 'onSaveTrabajador'
                    }
                }]
        }]


});