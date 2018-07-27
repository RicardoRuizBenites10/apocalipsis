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
            success: function (response, opts) {
                var responseText = Ext.decode(response.responseText);
                // Set the localStorage value to true
                localStorage.setItem("sesionUsuario", responseText.success);
            },
            failurer: function (response, opts) {
                Ext.Msg.alert('Status 20', response.status);
            }
        });
        
//        var loggedIn;
//        loggedIn = localStorage.getItem("sesionUsuario");
        // Remove Login Window
//        this.getView().destroy();
//        // Add the main view to the viewport
//        Ext.create({
//            xtype: loggedIn ? 'app-main' : 'login'
//        });     
        
    }

});
