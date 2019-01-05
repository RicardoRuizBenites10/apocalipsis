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
    treeNodeSelect: function (tree, node, opts) {
        var handler = node.get('handler');
        if (handler !== undefined && handler !== '' && handler !== null) {
            if (node.get('checked')) {
                var panel = this.lookupReference('mainBody');
                panel.removeAll();
                var panelView = Ext.create(handler);
                var codEtapa = node.get('codEtapa');
                if (codEtapa !== '') {
                    panelView.getViewModel().set('codEtapa', codEtapa);
                }
                panel.add(panelView);
            } else {
                Ext.Msg.show({
                    title: 'Error',
                    msg: 'No cuenta con permisos para acceder a esta pagina.',
                    icon: Ext.Msg.ERROR,
                    botones: Ext.Msg.OK
                });
            }
        }
    }

});
