
Ext.define('GrupoBruce.store.Usuario',{
    extend: 'Ext.data.Store',
    alias: 'store.usuario',
    
    model: 'usuario',
    
    proxy: {
        type: 'json',
        url: ''
    }
    
});