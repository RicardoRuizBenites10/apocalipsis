Ext.define('GrupoBruce.model.Chasis', {
    extend: 'Ext.data.Model',
    id: 'idChasis',
    fields: [
        { name: 'carroceria', type: 'string' },
        { name: 'ddee', type: 'int' },
        { name: 'idCarmod', type: 'string' },
        { name: 'idChapro', type: 'string' },
        { name: 'idChasis', type: 'int' },
        { name: 'modelo', type: 'string' },
        { name: 'proveedor', type: 'string' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiChasis',
            read: 'chasiss',
            update: 'uuChasis',
            destroy: 'ddChasis'
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
