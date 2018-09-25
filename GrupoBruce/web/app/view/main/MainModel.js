Ext.define('GrupoBruce.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        usuario: 'Oscar Ricardo Ruiz Benitessss',
        appname: 'Grupo Bruce',

        title_rrhh: 'Lista de Trabajadores',

        loremIpsum: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit.'
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
