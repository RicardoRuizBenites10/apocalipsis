Ext.define('GrupoBruce.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',

    validaSesion: function (btn) {
        var formLogin = btn.up('form');
        if (!formLogin.isDirty()) {
            Ext.Msg.alert('Status', 'Por favor ingresar información.');
            return;
        } else if (!formLogin.isValid()) {
            Ext.Msg.alert('Status', 'Información ingresada no es valida.');
            return;
        }

        Ext.Ajax.request({
            url: 'validate',
            jsonData: formLogin.getForm().getFieldValues(),
            method: 'POST',
            scope: this,
            success: this.onLoginSuccess,
            failurer: this.onLoginFailure
        });
    },

    onLoginSuccess: function (response, opts) {
        var responseText = Ext.decode(response.responseText);
        if (responseText.success) {
            if (responseText.data.estado) {
                localStorage.setItem("sesionEstado", responseText.success);
                localStorage.setItem("sesionUsuario", Ext.JSON.encode(responseText.data));
                this.getView().destroy();
                Ext.create({
                    xtype: 'app-main'
                });
            } else {
                Ext.Msg.show({
                    title: 'Error',
                    msg: "El usuario esta inactivo, comuniquese con el administrador.",
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        } else {
            Ext.Msg.show({
                title: 'Error',
                msg: responseText.message,
                icon: Ext.Msg.ERROR,
                botones: Ext.Msg.OK
            });
        }

    },

    onLoginFailure: function (response, opts) {
        Ext.Msg.alert('Status', response.status);
    }

});
