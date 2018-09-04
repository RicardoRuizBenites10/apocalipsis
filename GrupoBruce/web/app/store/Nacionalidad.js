Ext.define('GrupoBruce.store.Nacionalidad',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Nacionalidad',
    alias: 'store.Snacionalidad',
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'getBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

