Ext.define('GrupoBruce.model.TipoEstudio', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoEstudio',
    
    idProperty: 'idTestudio',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTestudio', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create : 'insertTipoEstudio',
            read: 'tiposEstudio',
            update: 'updateTipoEstudio',
            destroy: 'deleteTipoEstudio'
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
