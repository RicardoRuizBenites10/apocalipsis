
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
    bodyPadding: 20,
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
                    emptyText: 'Número de DNI',
                    allowBlank: false
                }, {
                    xtype: 'textfield',
                    name: 'clave',
                    fieldLabel: 'Contraseña',
                    inputType: 'password',
                    emptyText: 'Caracteres alfanuméricos',
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
