Ext.define('GrupoBruce.store.Trabajador',{
    extend: 'Ext.data.Model',
    alias: 'store.trabajador',
    
    model: 'trabajador',
    
    proxy: {
        url: 'trabajadores',
        type: 'ajax',
        
        reader: {
            type: 'json'
        }
        
    }
});