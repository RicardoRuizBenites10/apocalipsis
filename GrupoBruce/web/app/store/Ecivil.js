Ext.define('GrupoBruce.store.Ecivil',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Ecivil',
    alias: 'store.Secivil',
    
    proxy: {
        type: 'ajax',
        api:{
            read: 'ecivilBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

