Ext.define('GrupoBruce.model.RequerimientoMaterial', {
    extend: 'Ext.data.Model',
    alias: 'model.Mrequerimientomaterial',

    idProperty: 'idMaterial',
    fields: [
        {name: 'despachado', type: 'float'},
        {name: 'idMaterial', type: 'int'},
        {name: 'idRequerimiento', type: 'int'},
        {name: 'idUmedida', type: 'string'},
        {name: 'material', type: 'string'},
        {name: 'pendiente', type: 'boolean'},
        {name: 'requerido', type: 'float'},
        {name: 'stock', type: 'float'}
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiRequerimientoMaterial',
            read: 'requerimientomaterials',
            update: 'uuRequerimientoMaterial',
            destroy: 'ddRequerimientoMaterial'
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
