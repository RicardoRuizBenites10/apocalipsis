Ext.define('GrupoBruce.store.RegimenPensionario',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.RegimenPensionario',
    alias: 'store.SregimenPensionario',
    
    proxy: {
        type: 'ajax',
        api:{
            read: 'regimenPensionarioBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

