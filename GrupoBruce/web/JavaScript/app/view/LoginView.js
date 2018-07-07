Ext.define('GrupoBruce.view.login.Login',{
    extend:'Ext.window.Window',
    xtype: 'login',
    
    requeries: [
        'GrupoBruce.view.login.LoginController',
        'Ext.form.Panel'
    ],
    
    controller: 'login',
    bodyPadding: 10,
    title: 'Inicio de Sesión',
    closable: false,
    autoShow: true,
    
    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
            xtype: 'textfield',
            name: 'usu',
            fieldLabel: 'Usuario: ',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'clave',
            inputType: 'password',
            fieldLabel: 'Contraseña: ',
            allowBlank: false
        }, {
            xtype: 'displayfield',
            hideEmptyLabel: false,
            value: 'Enter any non-blank password'
        }],
        buttons: [{
            text: 'Ingresar',
            formBind: true,
            listeners: {
                click: 'onLoginClick'
            }
        }]
    }
});
