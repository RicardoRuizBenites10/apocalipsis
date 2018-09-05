Ext.define('GrupoBruce.store.FormaPago',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.FormaPago',
    alias: 'store.SformaPago',
    
    proxy: {
        type: 'ajax',
        api:{
            read: 'formaPagoBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

