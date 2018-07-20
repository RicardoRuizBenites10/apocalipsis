Ext.define('GrupoBruce.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    inicioSesion: function () {

        var form = this.lookupReference('formLogin');
        if (!form.isDirty()) {
            Ext.Msg.alert('Status', 'No new data to create.');
            return;
        } else if (!form.isValid()) {
            Ext.Msg.alert('Status', 'Invalid data.');
            return;
        }
        form.submit({
            url: 'validate.htm',
            method: 'POST',
            
            waitMsg: 'Accediendo al servidor..',
            
            headers: {
                'Content-Type': 'application/json'
            },
            clientValidation: true,
            submitEmptyText: true,

            success: function (form, action) {
                Ext.Msg.alert('Status', action.result.msg);
                // Set the localStorage value to true
                localStorage.setItem("sesionUsuario", true);
                // Remove Login Window
                this.getView().destroy();
                // Add the main view to the viewport
                Ext.create({
                    xtype: 'app-main'
                });
            },

            failurer: function (form, action) {
                Ext.Msg.alert('Status', action.result.msg);
            }
        });
    }

});
