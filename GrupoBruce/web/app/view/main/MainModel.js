Ext.define('GrupoBruce.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        appname: 'Grupo Bruce'
    },

    stores: {
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
            var usuario = get('thisUsuario');
            return usuario.trabajador;
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
