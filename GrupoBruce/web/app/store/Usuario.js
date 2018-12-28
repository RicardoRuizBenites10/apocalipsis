Ext.define('GrupoBruce.store.Usuario', {
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Usuario',
    alias: 'store.Susuario',

    remoteFilter: true,
    remoteSort: true,
    
    sorters: [{
            property: 'ID_USUARIO',
            direction: 'ASC'
        }]

});