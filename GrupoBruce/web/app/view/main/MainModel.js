Ext.define('GrupoBruce.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.main',

    data: {
        appname: 'Grupo Bruce'
    },

    stores: {
        trabajador: {
            type: 'Strabajador',
            autoLoad: true,
            loading: true,
            filters: [{
                    property: 'idTrabajador',
                    operator: 'EQ',
                    value: '{thisUsuario.idUsuario}'
                }]
        },
        navRol: {
            type: 'Sacceso',
            autoLoad: true,
            filters: [{
                    property: 'idRol',
                    value: '{myRol}'
                }]
        },
        empresas: {
            type: 'Sempresa',
            autoLoad: true,
            filters: [{
                    property: 'idEmpresa',
                    operator: 'eq',
                    value: '{thisUsuario.idEmpresa}'
                }]
        },
        sucursals: {
            type: 'Ssucursal',
            autoLoad: true,
            filters: [{
                    property: 'idSucursal',
                    operator: 'in',
                    value: '{thisUsuario.accSucursal}'
                }, {
                    property: 'idEmpresa',
                    operator: 'eq',
                    value: '{thisUsuario.idEmpresa}'
                }],
            listeners: {
                beforeload: function (store) {
                    var filter = store.getFilters().getAt(0);
                    filter.setValue(filter.getValue().toString());
                }
            }
        }
    },

    formulas: {
        myRol: function (get) {
            return get('thisUsuario').idRol;
        },

        thisUsuario: function () {
            return Ext.JSON.decode(localStorage.getItem("sesionUsuario"));
        },

        thisName: function (get) {
            return get('trabajador').getAt(0).get('nombresCompletos');
        },

        thisAvatar: function (get) {
            return get('trabajador').getAt(0).get('fotoB64');
        },

        altAvatar: function (get) {
            return get('trabajador').getAt(0).get('foto');
        },

        rootSelection: function (get) {
            var selection = get('treelist.selection'), path, array, accion;
            if (selection && selection.data.handler !== '') {
                path = selection.getPath('text');
                path = path.replace(/\/Root/, 'Menu');
                path = path.replace(/\//g, '<span class="x-fa fa-angle-right" style="padding: 0 18px 0 18px;"></span>');
                return  path;
            } else {
                return '';
            }
        }
    }

});
