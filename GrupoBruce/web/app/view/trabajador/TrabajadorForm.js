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
        },{
            xtype: 'textfield',
            name: 'this.getPersona().get("apPaterno")',
            fieldLabel: 'Ap. Paterno',
            allowBlank: false
        },{
            xtype: 'textfield',
            name: 'persona.apMaterno',
            fieldLabel: 'Ap. Materno',
            allowBlank: false
        },{
            xtype: 'textfield',
            name: 'persona.nombres',
            fieldLabel: 'Nombres',
            allowBlank: false
        },{
            xtype: 'datefield',
            fieldLabel: 'Nacimiento',
            name: 'persona.nacimiento'
        }]
});
