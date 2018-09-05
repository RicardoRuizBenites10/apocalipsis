Ext.define('GrupoBruce.store.Periocidad',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.Periocidad',
    alias: 'store.Speriocidad',
    
    proxy: {
        type: 'ajax',
        api:{
            read: 'periocidadBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});

