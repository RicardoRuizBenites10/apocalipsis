Ext.define('GrupoBruce.store.Empresa',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Empresa',
    alias: 'store.Sempresa',
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'empresaBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});