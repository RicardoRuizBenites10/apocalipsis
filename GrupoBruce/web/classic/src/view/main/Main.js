Ext.define('GrupoBruce.view.main.Main', {
    extend: 'Ext.panel.Panel',
    xtype: 'app-main',

    requires: [
        'Ext.plugin.Viewport',
        'GrupoBruce.view.main.MainController',
        'GrupoBruce.view.main.MainModel',

        'GrupoBruce.view.trabajador.Trabajador'
    ],

    controller: 'main',
    viewModel: 'main',
    plugins: 'viewport',

    title: 'GRUPO BRUCE S.A.',
    iconCls: 'x-fa fa-bus',
    header: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-list',
                text: 'Mi cuenta',
                menu: {
                    items: [{
                            text: 'Mi perfil',
                            checkHandler: 'onItemCheck'
                        }, {
                            text: 'Cerrar sesión',
                            handler: 'onCerrarSesion'
                        }]
                }
            }]
    },

    layout: 'border',
    items: [{
            region: 'west',
            width: 250,
            split: false,
//            collapsible: true,
            border: true,
            scrollable: 'y',
            cls: 'treelist-with-nav',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [{
                    xtype: 'treelist',
                    reference: 'treelist',
                    bind: '{navItems}'
                }]

        }, {
            region: 'center',
            bodyPadding: 0,
            layout: 'border',
            border: true,
            items: [{
                    region: 'center',
                    bodyPadding: 0
                }]
        }, {
            region: 'north',
            border: true
        }
    ]

});
