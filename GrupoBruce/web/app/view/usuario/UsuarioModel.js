Ext.define('GrupoBruce.view.usuario.UsuarioModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMusuario',
    data: {
        selectUsuario: null,
        selectTrabajador: null
    },

    stores: {
        usuarios: {
            type: 'Susuario',
            autoLoad: true
        },
        
        trabajadors: {
            type: 'Strabajador',
            autoLoad: true,
            sorters: [
                {property: 'apPaterno', direction: 'ASC'},
                {property: 'apMaterno', direction: 'ASC'},
                {property: 'nombres', direction: 'ASC'}
            ],
            listeners: {
                beforeload: function (store) {
                    var query = Ext.getCmp('id_trabajadorUsuario');
                    var valor = query !== undefined ? query.getValue() : 'x1';
                    store.getProxy().setExtraParam("query", valor);
                }
            }
        },
        rols: {
            type: 'Srol',
            autoLoad: true
        }
    },
    
    formulas: {
        vPass: function(get){
            return 'password';
        }
    }

});
