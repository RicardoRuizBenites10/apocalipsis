Ext.define('GrupoBruce.store.Comisionrp',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Comisionrp',
    alias: 'store.Scomisionrp',
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'comisionrpAll'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});