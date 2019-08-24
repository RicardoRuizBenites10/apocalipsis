Ext.define('GrupoBruce.model.MaterialUnidad', {
    extend: 'Ext.data.Model',
    idProperty: 'idUmedida',
    fields: [
        { name: 'base', type: 'boolean' },
        { name: 'denominacion', type: 'string' },
        { name: 'equivalencia', type: 'float' },
        { name: 'idMaterial', type: 'int' },
        { name: 'idUmedida', type: 'string' },
        { name: 'precio', type: 'float' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            destroy: 'ddLMaterialUnidad',
            create: 'iiLMaterialUnidad',
            read: 'materialunidads',
            update: 'uuLMaterialUnidad'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            allowSingle: false,
            writeAllFields: true
        }
    }
});
