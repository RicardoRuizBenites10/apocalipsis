Ext.define('GrupoBruce.model.ActividadMaterial', {
    extend: 'Ext.data.Model',
    idProperty: 'material',
    fields: [
        { name: 'cantidad', type: 'float' },
        { name: 'idActividad', type: 'int' },
        { name: 'idMaterial', type: 'int' },
        { name: 'idUmedida', type: 'string' },
        { name: 'material', type: 'string' },
        { name: 'unidad', type: 'string' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLActividadMaterial',
            read: 'actividadMaterials',
            update: 'uuLActividadMaterial',
            destroy: 'ddLActividadMaterial'
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
