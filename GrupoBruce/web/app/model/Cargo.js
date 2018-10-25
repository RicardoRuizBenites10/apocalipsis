Ext.define('GrupoBruce.model.Cargo', {
    extend: 'Ext.data.Model',
    alias: 'model.Mcargo',
    
    idProperty: 'idCargo',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idArea', type: 'string' },
        { name: 'idCargo', type: 'int' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean', defaultValue: true }
    ],
    
    identifier: {
        type: 'sequential'
    },
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiCargo',
            read: 'cargos',
            update: 'uuCargo',
            destroy: 'ddCargo'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
    
});
