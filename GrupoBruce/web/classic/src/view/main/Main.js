Ext.define('GrupoBruce.view.main.Main', {
    extend: 'Ext.panel.Panel',
    xtype: 'app-main',
    
    requires: [
        'Ext.plugin.Viewport',
        'GrupoBruce.view.main.MainController',
        'GrupoBruce.view.main.MainModel'
    ],
    
    controller: 'main',
    viewModel: 'main',
    plugins: 'viewport',
    title: 'GRUPO BRUCE S.A.',
    iconCls: 'x-fa fa-bus',
    
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
            region: 'west',
            reference: 'treelistContainer',
            width: 240,
            split: false,
            border: true,
            scrollable: 'y',
            cls: 'treelist-with-nav',
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            items: [{
                    xtype: 'container',
                    reference: 'tarjeta',
                    style: 'background-color: #f7f7f7 !important;padding: 10px;border-bottom:1px solid rgba(0, 0, 0, 0.1) !important;',
                    height: 92,
                    bodyPadding: 10,
                    layout: {
                        type: 'hbox',
                        align: 'stretch'
                    },
                    items: [{
                            xtype: 'image',
                            style: 'border: 4px solid #f2f2f2; border-radius: 50%;',
                            height: 80,
                            bind: {
                                src: '{thisAvatar}',
                                alt: '{altAvatar}'
                            },
                            flex: 1
                        }, {
                            xtype: 'container',
                            style: 'padding: 10px',
                            flex: 2,
                            bind: {
                                html: ' Bienvenido,  <br> <b>{thisName}</b>'
                            }
                        }]
                }, {
                    xtype: 'treelist',
                    reference: 'treelist',
                    ui: 'nav',
                    expanderOnly: false,
                    expanderFirst: false,
                    singleExpand: true,
                    bind: {
                        store: '{navItems}'
                    }
                    , listeners: {
//                        itemclick: function (treelist, ctx) {
//                            console.log("click");
//                        },
                        selectionchange: 'treeNodeSelect'

                    }
                }]

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
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                    },
                    items: [
//                        {
//                            bodyPadding: '15 15 0 15',
//                            bind: {
//                                html: '<b> {rootSelection} </b>'
//                            }
//                        }, 
                        {
                            reference: 'mainBody',
                            bodyPadding: 10
                        }]

                }]
        }
    ]

});
