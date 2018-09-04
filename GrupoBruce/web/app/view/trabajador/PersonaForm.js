Ext.define('GrupoBruce.view.trabajador.PersonaForm',{
    extend: 'Ext.form.Panel',
    
    xtype: 'personaForm',
    reference: 'form_persona',
    
    bodyPadding: 10,
    items: [{
            xtype: 'textfield',
            name: 'apPaterno',
            fieldLabel: 'Ap. Paterno',
            allowBlank: false
        },{
            xtype: 'textfield',
            name: 'apMaterno',
            fieldLabel: 'Ap. Materno',
            allowBlank: false
        },{
            xtype: 'textfield',
            name: 'nombres',
            fieldLabel: 'Nombres',
            allowBlank: false
        }]
});
