Ext.define('GrupoBruce.model.Area', {
    extend: 'Ext.data.Model',
    alias: 'model.Marea',
    
    idProperty: 'idArea',
    fields: [
        { name: 'idArea', type: 'string' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean' },
        { name: 'idSuparea', type: 'string' }
    ],
    
    identifier: {
        type: 'sequential'
    },
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiArea',
            read: 'areas',
            update: 'uuArea',
            destroy: 'ddArea'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
    
});
