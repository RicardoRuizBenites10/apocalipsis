Ext.define('GrupoBruce.model.TipoDocumento', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoDocumento',
    
    idProperty: 'idTdocumento',
    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'descripcion', type: 'string' },
        { name: 'descripcionAbreviada', type: 'string' },
        { name: 'idTdocumento', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'tipoDocumentoBySituacion',
            create: 'insertTipoDocumento',
            update: 'updateTipoDocumento',
            delete: 'deleteTipoDocumento'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});
