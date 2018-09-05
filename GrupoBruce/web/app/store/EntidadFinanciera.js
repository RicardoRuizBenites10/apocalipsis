Ext.define('GrupoBruce.store.EntidadFinanciera',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.EntidadFinanciera',
    alias: 'store.SentidadFinanciera',
    
    proxy: {
        type: 'ajax',
        api:{
            read: 'entidadFinancieraBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

