Ext.define('GrupoBruce.model.TipoEquipo', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoEquipo',
    
    idProperty: 'idTequipo',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTequipo', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTipoEquipo',
            read: 'tiposEquipo',
            update: 'uuTipoEquipo',
            destroy: 'ddTipoEquipo'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
