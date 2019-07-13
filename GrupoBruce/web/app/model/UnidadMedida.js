Ext.define('GrupoBruce.model.UnidadMedida', {
    extend: 'Ext.data.Model',
    alias: 'model.Munidadmedida',
    
    idProperty: 'idUmedida',
    fields: [
        { name: 'denominacion', type: 'string' },
        { name: 'equivalencia', type: 'float' },
        { name: 'idUmedida', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiUnidadMedida',
            read: 'unidadMedidas',
            update: 'uuUnidadMedida',
            destroy: 'ddUnidadMedida'
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
