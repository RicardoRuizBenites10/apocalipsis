Ext.define('GrupoBruce.model.MaterialUnidad', {
    extend: 'Ext.data.Model',
    idProperty: 'idUmedida',
    fields: [
        { name: 'base', type: 'boolean' },
        { name: 'denominacion', type: 'string' },
        { name: 'idMaterial', type: 'int' },
        { name: 'idUmedida', type: 'int' },
        { name: 'precio', type: 'float' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMaterialUnidad',
            read: 'materialUnidads',
            update: 'uuMaterialUnidad',
            destroy: 'ddMaterialUnidad'
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
