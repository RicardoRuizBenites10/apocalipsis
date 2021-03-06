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
    
    bind: {
        title: '{titLogin}'
    },

    bodyPadding: 20,
    closable: false,
    autoShow: true,
    resizable: false,
    
    items: [{
            xtype: 'form',
            reference: 'formSesion',

            items: [{
                    xtype: 'textfield',
                    name: 'usu',
                    fieldLabel: 'Usuario',
                    emptyText: 'Número de DNI',
                    allowBlank: false
                }, {
                    xtype: 'textfield',
                    name: 'deClave',
                    fieldLabel: 'Contraseña',
                    inputType: 'password',
                    emptyText: 'Caracteres alfanuméricos',
                    allowBlank: false
                }],
            buttons: [{
                    text: 'Ingresar',
                    formBind: true,
                    listeners: {
                        click: 'validaSesion'
                    }
                }]
        }]
});
