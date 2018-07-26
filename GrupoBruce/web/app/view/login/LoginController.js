Ext.define('GrupoBruce.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    validaSesion: function () {

        var formLogin = this.lookupReference('formSesion');

        if (!formLogin.isDirty()) {
            Ext.Msg.alert('Status', 'No hay informacion que guardar.');
            return;
        } else if (!formLogin.isValid()) {
            Ext.Msg.alert('Status', 'Información ingresada no es valida.');
            return;
        }

        Ext.Ajax.request({
            url: 'validate',
            jsonData: formLogin.getForm().getValues(),
            method: 'POST',
            
            success: function (response) {
                // Set the localStorage value to true
                localStorage.setItem("sesionUsuario", true);
                // Remove Login Window
                formLogin.getForm().destroy();
                // Add the main view to the viewport
                Ext.create({
                    xtype: 'app-main'
                });
            },
            
            failurer: function (response) {
                Ext.Msg.alert('Status 20', response.status);
            }
        });

//        formLogin.submit({
//            url: 'validate',
//            method: 'POST',
//            type: 'json',
//            jsonData: formLogin.getForm().getValues(),
//
//            waitMsg: 'Accediendo al servidor..',
//
//            headers: {
//                'Content-Type': 'application/json'
//            },
//
//            clientValidation: true,
//            submitEmptyText: true,
//
//            success: function (form, action) {
//                Ext.Msg.alert('Status', action.result.msg);
//                // Set the localStorage value to true
//                localStorage.setItem("sesionUsuario", true);
//                // Remove Login Window
//                this.getView().destroy();
//                // Add the main view to the viewport
//                Ext.create({
//                    xtype: 'app-main'
//                });
//            },
//
//            failurer: function (form, action) {
//                Ext.Msg.alert('Status', action.result.msg);
//            }
//        });
    }

});
