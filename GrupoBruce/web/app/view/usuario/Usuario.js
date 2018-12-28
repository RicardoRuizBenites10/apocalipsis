Ext.define('GrupoBruce.view.usuario.Usuario',{
    extend: 'Ext.panel.Panel',

    requires: [
        'GrupoBruce.view.usuario.UsuarioController',
        'GrupoBruce.view.usuario.UsuarioModel',
        
        'GrupoBruce.view.usuario.ListUsuario',
        'GrupoBruce.view.usuario.FormUsuario'
    ],

    controller: 'Cusuario',
    viewModel: {
        type: 'VMusuario'
    },

    items: [{
            xtype: 'WlistUsuario',
            id: 'id_wusuario',
            height: 520
    }]
});
