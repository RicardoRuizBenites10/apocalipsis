/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('GrupoBruce.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    onItemSelected: function (sender, record, item, index) {
//        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
            Ext.Msg.alert("Prueba","Datos: " + Ext.encode(record.getData()));
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    },
    
    onClickButton: function () {
        // Remove the localStorage key/value
        localStorage.removeItem('sesionUsuario');

        // Remove Main View
        this.getView().destroy();

        // Add the Login Window
        Ext.create({
            xtype: 'login'
        });
    }
    
});
