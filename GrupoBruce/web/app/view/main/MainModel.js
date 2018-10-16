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
                                iconCls: 'x-fa fa-wrench',
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
                                        text: 'Periodo Vacacion',
                                        iconCls: null,
                                        leaf: true,
                                        handler: 'GrupoBruce.view.periodovacacion.PeriodoVacacion'
                                    }, {
                                        text: 'Afiliación trabajador',
                                        iconCls: null,
                                        leaf: true
                                    }]
                            }, {
                                text: 'Trabajador',
                                iconCls: 'x-fa fa-male',
                                leaf: true,
                                handler: 'GrupoBruce.view.trabajador.Trabajador'
                            }]
                    }, {
                        text: 'Logistica',
                        iconCls: 'x-fa fa-folder',
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
                        iconCls: 'x-fa fa-folder-open',
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
            return get('thisUsuario').fotoB64;
        },

        altAvatar: function (get) {
            return get('thisUsuario').foto;
        },

        rootSelection: function (get) {
            var selection = get('treelist.selection'), path, array, accion;
            if (selection) {
                path = selection.getPath('text');
                path = path.replace(/^\/Root/, '');
                return 'Seleccionado: ' + path;
            } else {
                return 'No node selected';
            }
        }
    }

});
