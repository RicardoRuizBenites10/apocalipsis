/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('GrupoBruce.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.main',

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    },

    onCerrarSesion: function () {
        // Remove the localStorage key/value
        localStorage.removeItem('sesionEstado');
        localStorage.removeItem('sesionUsuario');

        // Remove Main View
        this.getView().destroy();

        // Add the Login Window
        Ext.create({
            xtype: 'login'
        });
    },

    onShowBody: function () {
        Ext.Msg.alert('Titulo', 'Cuerpo');
    },

    onToggleNav: function (button, pressed) {
        

    },

    onToggleMicro: function (button, pressed) {
        var treelist = this.lookupReference('treelist'),
                navBtn = this.lookupReference('navBtn'),
                target = this.lookupReference('tarjeta'),
                ct = treelist.ownerCt;

        treelist.setMicro(pressed);
        target.setHidden(pressed);
        if (pressed) {
            this.oldWidth = ct.width;
            ct.setWidth(36);
        } else {
            ct.setWidth(this.oldWidth);
            navBtn.enable();
        }
    },

    treeNodeSelect: function (tree, record, ndx, opts) {
        //Do Something Here With The Selected Node
        Ext.Msg.alert('Hola', 'Que tal');
    }

});
