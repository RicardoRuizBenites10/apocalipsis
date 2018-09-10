Ext.define('GrupoBruce.view.trabajador.TrabajadorForm', {
    extend: 'Ext.form.Panel',

    xtype: 'trabajadorForm',
    reference: 'form_trabajador',

    defaults: {
        xtype: 'container',
        layout: 'hbox',
        defaults: {
            labelAlign: 'top',
            padding: 5
        }
    },
    viewModel: true,
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
                    }
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
                }]
        }, {
            items: [{
                    xtype: 'combobox',
                    name: 'idRpensionario',
                    fieldLabel: 'Regimen pensionario :',
                    displayField: 'descripcion',
                    valueField: 'idRpensionario',
                    reference: 'cboRPensionario',
                    publishes: 'value',
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
                    bind:{
                        filters: {
                            property: 'idRpensionario',
                            value: '{cboRPensionario.idRpensionario}'
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
                    bind:{
                        filters:{
                           property: 'idSucursal',
                            value: '{cboEmpresa.values}' 
                        }
                    },
                    store: {
                        type: 'Ssucursal',
                        autoLoad: true
                    }
                }]
        }]
});
