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
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [{
                    xtype: 'treelist',
                    reference: 'treelist',
                    cls: 'treelist-with-nav',
                    bind: '{navItems}'
                }]

        }, {
            region: 'center',
            bodyPadding: 0,
            layout: 'border',
            items: [{
                    region: 'center',
                    bodyPadding: 0
                }, {
                    region: 'south',
                    border: true,
                    html: '<h4>EPRESA CARROCERA "FACTORIA BRUCE S.A." </h4>'
                }]
        }, {
            region: 'north',
            border: true
        }
    ]

});
