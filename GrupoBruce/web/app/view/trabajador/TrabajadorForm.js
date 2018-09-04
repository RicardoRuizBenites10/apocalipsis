Ext.define('GrupoBruce.view.trabajador.TrabajadorForm', {
    extend: 'Ext.form.Panel',
    
    xtype: 'trabajadorForm',
    reference: 'form_trabajador',

    bodyPadding: 10,
    items: [{
            xtype: 'textfield',
            name: 'idTrabajador',
            fieldLabel: 'Número DNI',
            allowBlank: false
        }]
});
