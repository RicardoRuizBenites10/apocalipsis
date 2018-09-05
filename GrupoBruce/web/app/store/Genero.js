Ext.define('GrupoBruce.store.Genero',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Genero',
    alias: 'store.Sgenero',
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'generoBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});