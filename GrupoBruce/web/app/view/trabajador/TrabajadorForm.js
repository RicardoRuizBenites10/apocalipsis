Ext.define('GrupoBruce.view.trabajador.TrabajadorForm', {
    extend: 'Ext.form.Panel',
    xtype: 'trabajadorForm',
    
    reference: 'form_trabajador',

    items: [{
            xtype: 'textfield',
            fieldlabel: 'Ap. Paterno',
            allowBlank: false
        }]
});
