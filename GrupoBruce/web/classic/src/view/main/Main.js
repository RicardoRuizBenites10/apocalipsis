Ext.define('GrupoBruce.view.main.Main', {
    extend: 'Ext.tab.Panel',
    xtype: 'app-main',

    requires: [
        'Ext.plugin.Viewport',
        'Ext.window.MessageBox',

        'GrupoBruce.view.main.MainController',
        'GrupoBruce.view.main.MainModel',

        'GrupoBruce.view.trabajador.Trabajador'
    ],

    controller: 'main',
    viewModel: 'main',

    plugins: 'viewport',

    ui: 'navigation',

    tabBarHeaderPosition: 1,

    titleRotation: 0,
    tabRotation: 0,

    header: {
        layout: {
            align: 'stretchmax'
        },
        title: {
            bind: {
                text: '{appname}'
            },
            flex: 0
        },
        items: [{
                xtype: 'button',
                iconCls: 'fa fa-user',
                bind: {
                    text: '{thisName}'
                },
                menu: [{
                        text: 'Mi perfil'
                    }, {
                        text: 'Cerrar sesión',
                        handler: 'onClickButton'
                    }]
            }]
    },

    tabBar: {
        flex: 1,
        scrollable: true,
        layout: {
            align: 'stretch',
            overflowHandler: 'none'
        }
    },

    responsiveConfig: {
        tall: {
            headerPosition: 'top'
        },
        wide: {
            headerPosition: 'left'
        }
    },

    defaults: {
        bodyPadding: 10,
        tabConfig: {
            plugins: 'responsive',
            responsiveConfig: {
                wide: {
                    iconAlign: 'left',
                    textAlign: 'left'
                },
                tall: {
                    iconAlign: 'top',
                    textAlign: 'center',
                    width: 60
                }
            }
        }
    },

    items: [{
            title: ' Recursos Humanos',
            iconCls: 'fa-male',
            items: [{
                    bind: {
                        title: '{title_rrhh}'
                    },
                    xtype: 'trabajadors'
                }]
        }, {
            title: 'Logistica',
            iconCls: 'fa-folder-o',
            bind: {
                html: '{loremIpsum}'
            }
        }, {
            title: 'Ingeniería y diseño',
            iconCls: 'fa-crop',
            items: [{
                    title: 'Módulo de Ingeniería',
                    html: 'dadada',
                    closable: true,
                    iconCls: 'fa fa-home'
                }]
        }, {
            title: 'Producción',
            iconCls: 'fa-cog',
            bind: {
                html: '{loremIpsum}'
            }
        }, {
            title: 'Control de calidad',
            iconCls: 'fa-check-square-o'
        }, {
            title: 'Sistemas',
            iconCls: 'fa-code',
            bind: {
                html: '{loremIpsum}'
            }
        }, {
            title: 'Reportes',
            iconCls: 'fa-bar-chart-o'
        }]
});