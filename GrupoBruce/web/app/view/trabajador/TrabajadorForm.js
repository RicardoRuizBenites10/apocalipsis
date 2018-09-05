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
    items: [{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Tipo trabajador :',
                    displayField: 'descripcion',
                    valueField: 'idTtrabajador',
                    store: {
                        type: 'StipoTrabajador',
                        autoLoad: true
                    }
                }, {
                    xtype: 'combobox',
                    fieldLabel: 'Regimen pensionario :',
                    displayField: 'descripcion',
                    valueField: 'idRpensionario',
                    store: {
                        type: 'SregimenPensionario',
                        autoLoad: true
                    }
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Nro CUSPP :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Banco CTS :',
                    displayField: 'nombre',
                    valueField: 'idEfinanciera',
                    store: {
                        type: 'SentidadFinanciera',
                        autoLoad: true
                    }
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Cuenta CTS :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Forma Pago :',
                    displayField: 'descripcion',
                    valueField: 'idFpago',
                    store: {
                        type: 'SformaPago',
                        autoLoad: true
                    }
                }, {
                    xtype: 'combobox',
                    fieldLabel: 'Periocidad de Pago :',
                    displayField: 'descripcion',
                    valueField: 'idPeriocidad',
                    store: {
                        type: 'Speriocidad',
                        autoLoad: true
                    }
                },{
                    xtype: 'numberfield',
                    hideTrigger: true,
                    minValue: 0,
                    name: 'montoPasaje',
                    fieldLabel: 'Monto pasaje :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Banco sueldo :',
                    displayField: 'nombre',
                    valueField: 'idEfinanciera',
                    store: {
                        type: 'SentidadFinanciera',
                        autoLoad: true
                    }
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Cuenta sueldo :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Situación trabajador :',
                    displayField: 'descripcion',
                    valueField: 'idEtrabajador',
                    store: {
                        type: 'SestadoTrabajador',
                        autoLoad: true
                    }
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Empresa :',
                    displayField: 'descripcion',
                    valueField: 'idEmpresa',
                    store: {
                        type: 'Sempresa',
                        autoLoad: true
                    }
                }, {
                    xtype: 'combobox',
                    fieldLabel: 'Lugar de trabajo :',
                    flex: 2
                }]
        }]
});
