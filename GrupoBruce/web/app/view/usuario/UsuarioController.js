Ext.define('GrupoBruce.view.usuario.UsuarioController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.usuario',
    
    onLoginClick: function() {

        // This would be the ideal location to verify the user's credentials via
        // a server-side lookup. We'll just move forward for the sake of this example.

        // Set the localStorage value to true
        localStorage.setItem("validacionUsuario", false);

        // Remove Login Window
        this.getView().destroy();

        // Add the main view to the viewport
        Ext.create({
            xtype: 'app-main'
        });

    }
});
