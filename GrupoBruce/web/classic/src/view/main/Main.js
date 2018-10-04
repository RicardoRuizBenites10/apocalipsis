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
                text: 'Min',
                enableToggle: true,
                toggleHandler: 'onToggleMicro'
            }, {
                xtype: 'button',
                iconCls: 'x-fa fa-envelope-o',
                text: '(4)',
                tooltip: 'Revisar correos',

                enableToggle: true,
                reference: 'navBtn',
                toggleHandler: 'onToggleNav'
            }, {
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
            reference: 'treelistContainer',
            width: 230,
            split: false,
            border: false,
            scrollable: 'y',
            cls: 'treelist-with-nav',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [{
                    xtype: 'panel',
                    reference: 'tarjeta',
                    height: 90,
                    bodyPadding: 10,
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [{
                            xtype: 'image',
                            style: 'border: 4px solid #fafafa; border-radius: 50%;',
                            width: 70,
                            bind: {
                                src: '{thisAvatar}'
                            },
                            flex: 1
                        }, {
                            xtype: 'panel',
                            style: 'padding: 2px 10px',
                            flex: 2,
                            bind: {
                                html: '<span> Bienvenido, </span> <h4>{thisName}</h4>'
                            }
                        }]
                }, {
                    xtype: 'treelist',
                    reference: 'treelist',
                    ui: 'nav',
                    expanderOnly: false,
                    singleExpand: true,
                    expanderFirst: false,
                    bind: '{navItems}'
                }]

        }, {
            region: 'center',
            layout: 'border',
            border: true,
            items: [{
                    region: 'center',
                    bodyPadding: 0
                }]
        }
        , {
            region: 'north',
            border: true
        }
    ]

});