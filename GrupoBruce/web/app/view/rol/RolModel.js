Ext.define('GrupoBruce.view.rol.RolModel', {
    extend: 'Ext.app.ViewModel',
    alias: 'viewmodel.VMrol',
    
    data: {
        title: 'Lista de roles de usuarios'
    },

    stores: {
        rols: {
            type: 'Srol',
            autoLoad: true
        }
    }
});
