Ext.define('GrupoBruce.view.main.Main', {
    extend: 'Ext.panel.Panel',
    xtype: 'app-main',
    reference: 'main',
    id: 'id_wmain',

    requires: [
        'Ext.plugin.Viewport',
        'GrupoBruce.view.main.MainController',
        'GrupoBruce.view.main.MainModel',

        'GrupoBruce.view.main.MainMenu'
    ],

    mixins: [
        'Ext.mixin.Responsive'
    ],

    responsiveFormulas: {
        small: 'height < 600',
        medium: 'height >= 600 && height < 800',
        large: 'height >= 800'
    },

    controller: 'main',
    viewModel: {
        type: 'main'
    },
    plugins: 'viewport',
    iconCls: 'x-fa fa-bus',
    title: 'GRUPO BRUCE S.A.',

    header: {
        items: [{
                xtype: 'button',
                iconCls: 'x-fa fa-envelope-o',
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
            xtype: 'Wmainmenu',
            region: 'west',
            split: false,
            border: true
        }, {
            region: 'center',
            layout: 'border',
            border: true,
//            dockedItems: [{
//                    xtype: 'toolbar',
//                    dock: 'left',
//                    items: [{
//                            xtype: 'button',
//                            iconCls: 'x-fa fa-bars',
//                            enableToggle: true,
//                            toggleHandler: 'onToggleMicro'
//                        }
//                    ]
//                }],
            items: [{
                    region: 'center',
                    scrollable: 'y',
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
                        {
                            bodyPadding: '15 15 0 15',
                            bind: {
                                html: '{rootSelection}'
                            }
                        },
//                        {
//                            xtype: 'breadcrumb',
//                            rootVisible: false,
//                            bind: {
//                                store: '{navRol}',
//                                selection: '{selectMenu}'
//                            }
//                        },
                        {
                            reference: 'mainBody',
                            bodyPadding: 10
                        }]
                }]
        }]

});
