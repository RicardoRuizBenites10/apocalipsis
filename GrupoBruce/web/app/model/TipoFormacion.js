Ext.define('GrupoBruce.model.TipoFormacion', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoFormacion',
    
    idProperty: 'idTformacion',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTformacion', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
        
    proxy: {
        type: 'ajax',
        api: {
            create : 'insertTipoFormacion',
            read: 'tiposFormacion',
            update: 'updateTipoFormacion',
            destroy: 'deleteTipoFormacion'
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
