Ext.define('GrupoBruce.view.login.LoginController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.login',
    
    inicioSesion: function(){
        
        var form = this.lookupReference('formLogin');
        if (!form.isDirty()) {
            Ext.Msg.alert('Status', 'No new data to create.');
            return;
        }
        else if (!form.isValid()) {
            Ext.Msg.alert('Status', 'Invalid data.');
            return;
        }
        form.submit({
            url: '/validate.htm',
            waitMsg: 'Saving..',
            headers: {
                'Content-Type': 'application/json'
            },
            clientValidation: true,
            submitEmptyText: true,
            
            success: function(){
                Ext.Msg.alert('Status', 'Saved successfully.');
            },
            
            failurer: function(){
                Ext.Msg.alert('Status', 'Saved error.');
            }
        });
        
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
