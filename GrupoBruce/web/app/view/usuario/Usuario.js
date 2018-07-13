
Ext.define('GrupoBruce.view.usuario.Usuario',{
    extend: 'Ext.window.Window',

    xtype: 'login',

    requires: [
        'GrupoBruce.view.usuario.UsuarioController',
        'GrupoBruce.view.usuario.UsuarioModel',
        
        'Ext.form.Panel'
    ],

    controller: 'vc-usuario',
    viewModel: {
        type: 'vm-usuario'
    },
    
    bodyPadding: 10,
    title: 'Inicio de Sesión',
    closable: false,
    autoShow: true,
    
    items: {
        xtype: 'form',
        reference: 'formLogin',
        items: [{
            xtype: 'textfield',
            name: 'username',
            fieldLabel: 'Usuario',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: 'Contraseña',
            allowBlank: false
        }, {
            xtype: 'displayfield',
            hideEmptyLabel: false,
            value: 'No dejar espacios en blanco'
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
