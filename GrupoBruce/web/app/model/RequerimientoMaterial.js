Ext.define('GrupoBruce.model.RequerimientoMaterial', {
    extend: 'Ext.data.Model',
    alias: 'model.Mrequerimientomaterial',

    idProperty: 'idMaterial',
    fields: [
        {name: 'estandar', type: 'float'},
        {name: 'despachado', type: 'float'},
        {name: 'despachadot', type: 'float'},
        {name: 'idMaterial', type: 'int'},
        {name: 'idRequerimiento', type: 'int'},
        {name: 'idUmedida', type: 'string'},
        {name: 'material', type: 'string'},
        {name: 'requerido', type: 'float'},
        {name: 'requeridot', type: 'float'},
        {name: 'stock', type: 'float'}
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLRequerimientoMaterial',
            read: 'requerimientomaterials',
            update: 'uuLRequerimientoMaterial',
            destroy: 'ddLRequerimientoMaterial'
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
