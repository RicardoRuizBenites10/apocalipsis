
Ext.define('GrupoBruce.store.Usuario',{
    extend: 'Ext.data.Store',
    
    alias: 'store.usuario',
    
    model: 'usuario',
    
    proxy: {
        type: 'json',
        url: 'validate.htm',
        
        api: {
            read: '',
            create: '',
            update: '',
            delete: ''
        },
        
        reader: {
             type: 'json',
             root: 'data'
         }
    },
    
    autoLoad: true
    
});