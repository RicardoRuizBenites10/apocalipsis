Ext.define('GrupoBruce.store.TipoDocumento',{
    extend: 'Ext.data.Store',
    model: 'GrupoBruce.model.TipoDocumento',
    alias: 'store.StipoDocumento',
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'tipoDocumentoBySituacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});