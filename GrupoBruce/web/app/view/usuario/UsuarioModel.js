Ext.define('GrupoBruce.view.usuario.UsuarioModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMusuario',
    data: {
        selectUsuario: null,
        usu: '4609'
    },

    stores: {
        usuarios: {
            type: 'Susuario',
            autoLoad: true
        },
        rols: {
            type: 'Srol',
            autoLoad: true
        }
    }

});
