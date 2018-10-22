Ext.define('GrupoBruce.model.TipoAusencia', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoAusencia',
    
    idProperty: 'idTausencia',
    fields: [
        { name: 'descrpcion', type: 'string' },
        { name: 'idTausencia', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'tiposAusencia',
            create: 'insertTipoAusencia',
            update: 'updateTipoAusencia',
            delete: 'deleteTipoAusencia'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
