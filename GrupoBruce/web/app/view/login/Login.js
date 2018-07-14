
Ext.define('GrupoBruce.view.login.Login', {
    extend: 'Ext.window.Window',

    xtype: 'login',

    requires: [
        'GrupoBruce.view.login.LoginController',
        'GrupoBruce.view.login.LoginModel',

        'Ext.form.Panel'
    ],

    controller: 'login',
    viewModel: {
        type: 'login'
    },

    title: 'INICIO DE SESIÓN',
    bodyPadding: 10,
    closable: false,
    autoShow: true,
    resizable: false,

    items: [{
            xtype: 'form',
            reference: 'formLogin',
            items: [{
                    xtype: 'textfield',
                    name: 'usu',
                    fieldLabel: 'Usuario',
                    allowBlank: false
                }, {
                    xtype: 'textfield',
                    name: 'clave',
                    fieldLabel: 'Contraseña',
                    inputType: 'password',
                    allowBlank: false
                }],
            buttons: [{
                    text: 'Ingresar',
                    formBind: true,
                    listeners: {
                        click: 'inicioSesion'
                    }
                }]
        }]
});
