
Ext.define('GrupoBruce.view.usuario.Usuario',{
    extend: 'Ext.window.Window',

    xtype: 'usuario',

    requires: [
        'GrupoBruce.view.usuario.UsuarioController',
        'GrupoBruce.view.usuario.UsuarioModel',
        'Ext.form.Panel'
    ],

    controller: 'usuario',
    viewModel: {
        type: 'usuario'
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
            fieldLabel: 'Usuario :',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: 'Contraseña :',
            allowBlank: false
        }, {
            xtype: 'displayfield',
            hideEmptyLabel: false,
            value: 'No dejar en blanco contraseña'
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
