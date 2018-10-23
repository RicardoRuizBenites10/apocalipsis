Ext.define('GrupoBruce.model.Area', {
    extend: 'Ext.data.Model',
    alias: 'model.Marea',
    
    fields: [
        { name: 'idArea', type: 'int' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean' },
        { name: 'idSuparea', type: 'int' },
        { name: 'mtype', type: 'string' },
        { name: 'parentId', type: 'string' }
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
            rootProperty: 'data',
            typeProperty: 'mtype'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
    
});
