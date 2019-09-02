Ext.define('GrupoBruce.model.MaterialUnidad', {
    extend: 'Ext.data.Model',
    idProperty: 'idUmedida',
    fields: [
        { name: 'base', type: 'boolean' },
        { name: 'denominacion', type: 'string' },
        { name: 'equivalencia', type: 'float' },
        { name: 'idEmpresa', type: 'string' },
        { name: 'idMaterial', type: 'int' },
        { name: 'idSucursal', type: 'string' },
        { name: 'idUmedida', type: 'string' },
        { name: 'precio', type: 'float' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLMaterialUnidad',
            read: 'materialunidads',
            update: 'uuLMaterialUnidad',
            destroy: 'ddLMaterialUnidad'
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
