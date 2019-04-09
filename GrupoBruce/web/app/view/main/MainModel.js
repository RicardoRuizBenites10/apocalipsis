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
        }
    },

    formulas: {
        myRol: function(get){
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
