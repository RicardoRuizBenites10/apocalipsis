Ext.define('GrupoBruce.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        usuario: 'Oscar Ricardo Ruiz Benitessss',
        appname: 'Grupo Bruce',

        title_rrhh: 'Lista de Trabajadores',

        loremIpsum: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.'
    },

    stores: {
        navItems: {
            type: 'tree',
            root: {
                expanded: true,
                children: [{
                        text: 'Recursos Humanos',
                        iconCls: 'x-fa fa-users',
                        children: [{
                                text: 'Mantenimientos',
                                iconCls: null,
                                children: [{
                                        text: 'Áreas de trabajo',
                                        iconCls: null,
                                        leaf: true
                                    }, {
                                        text: 'Tipos trabajador',
                                        iconCls: null,
                                        leaf: true
                                    }, {
                                        text: 'Estados trabajador',
                                        iconCls: null,
                                        leaf: true
                                    }, {
                                        text: 'Regimen pensionario',
                                        iconCls: null,
                                        leaf: true
                                    }, {
                                        text: 'Entidades bancarias',
                                        iconCls: null,
                                        leaf: true
                                    }, {
                                        text: 'Afiliación trabajador',
                                        iconCls: null,
                                        leaf: true
                                    }]
                            }, {
                                text: 'Trabajador',
                                iconCls: 'x-fa fa-male',
                                leaf: true,
                                handler: 'onShowBody'
                            }]
                    }, {
                        text: 'Logistica',
                        iconCls: 'x-fa fa-folder-o',
                        children: [{
                                text: 'Ordenes de compra',
                                iconCls: null,
                                leaf: true
                            }, {
                                text: 'Ordenes de trabajo',
                                iconCls: null,
                                leaf: true
                            }]
                    }, {
                        text: 'Almacén',
                        iconCls: 'x-fa fa-folder',
                        children: [{
                                text: 'Operaciones',
                                iconCls: null,
                                leaf: true
                            }, {
                                text: 'Guias de remisión',
                                iconCls: null,
                                leaf: true
                            }]
                    }, {
                        text: 'Ingeniería y Diseño',
                        iconCls: 'x-fa fa-crop',
                        children: [{
                                text: 'Gestión de planos',
                                iconCls: null,
                                leaf: true
                            }, {
                                text: 'Modelos de carrocería',
                                iconCls: null,
                                leaf: true
                            }]
                    }, {
                        text: 'Producción',
                        iconCls: 'x-fa fa-bus',
                        children: [{
                                text: 'Mantenimientos',
                                iconCls: null,
                                children: [{
                                        text: 'Etapas de proceso',
                                        iconCls: null,
                                        leaf: true
                                    }, {
                                        text: 'Actividades',
                                        iconCls: null,
                                        leaf: true
                                    }]
                            }, {
                                text: 'Estandares',
                                iconCls: null,
                                leaf: true
                            }, {
                                text: 'Vales de salida',
                                iconCls: null,
                                leaf: true
                            }]
                    }, {
                        text: 'Control de calidad',
                        iconCls: 'x-fa fa-check-square-o',
                        children: [{
                                text: 'Calidad de materiales',
                                iconCls: null,
                                leaf: true
                            }, {
                                text: 'Calidad de producción',
                                iconCls: null,
                                leaf: true
                            }]
                    }, {
                        text: 'Sistemas',
                        iconCls: 'x-fa fa-code',
                        children: [{
                                text: 'Dispositivos',
                                iconCls: null,
                                leaf: true
                            }]
                    }]
            }
        }
    },

    formulas: {
        thisUsuario: function () {
            return Ext.JSON.decode(localStorage.getItem("sesionUsuario"));
        },

        thisName: function (get) {
            var usuario = get('thisUsuario');
            return usuario.nombres + ' ' + usuario.apPaterno + ' ' + usuario.apMaterno;
        },

        thisAvatar: function (get) {
            return get('thisUsuario').avatarB64;
        }
    }

});
