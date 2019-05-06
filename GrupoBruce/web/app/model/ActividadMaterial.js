Ext.define('GrupoBruce.model.ActividadMaterial', {
    extend: 'Ext.data.Model',
    idProperty: 'idMaterial',
    fields: [
        { name: 'cantidad', type: 'float' },
        { name: 'idActividad', type: 'int' },
        { name: 'idMaterial', type: 'int' },
        { name: 'idUmedida', type: 'int' },
        { name: 'material', type: 'string' },
        { name: 'unidad', type: 'string' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiActividadMaterial',
            read: 'actividadMaterials',
            update: 'uuActividadMaterial',
            destroy: 'ddActividadMaterial'
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
