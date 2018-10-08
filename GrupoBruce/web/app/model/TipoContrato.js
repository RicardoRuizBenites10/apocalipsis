Ext.define('GrupoBruce.model.TipoContrato', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idTcontrato',
    fields: [
        { name: 'idTcontrato', type: 'string' },
        { name: 'situacion', type: 'boolean' },
        { name: 'descripcion', type: 'string' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'tipoContratos',
            create: 'insertTipoContrato',
            update: 'updateTipoContrato',
            delete: 'deleteTipoContrato'
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
