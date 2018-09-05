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
                    fieldLabel: 'Tipo trabajador :'
                }, {
                    xtype: 'combobox',
                    fieldLabel: 'Regimen pensionario :'
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Nro CUSPP :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Banco CTS :'
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Cuenta CTS :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Forma Pago :'
                }, {
                    xtype: 'combobox',
                    fieldLabel: 'Periocidad de Pago :'
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Monto pasaje :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Banco sueldo :'
                },{
                    xtype: 'textfield',
                    fieldLabel: 'Cuenta sueldo :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Situación trabajador :'
                }]
        },{
            items: [{
                    xtype: 'combobox',
                    fieldLabel: 'Empresa :'
                }, {
                    xtype: 'combobox',
                    fieldLabel: 'Lugar de trabajo :',
                    flex: 2
                }]
        }]
});
