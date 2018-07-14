Ext.define('GrupoBruce.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',
    
    inicioSesion: function(){
        var form = this.lookupReference('formLogin');
        
        // This would be the ideal location to verify the user's credentials via
        // a server-side lookup. We'll just move forward for the sake of this example.

        // Set the localStorage value to true
        localStorage.setItem("sesionUsuario", true);

        // Remove Login Window
        this.getView().destroy();

        // Add the main view to the viewport
        Ext.create({
            xtype: 'app-main'
        });
        
    }
    
});
