Ext.define('GrupoBruce.model.Especificacion', {
    extend: 'Ext.data.Model',
    idProperty: 'idEspecificacion',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'fechaInsert', type: 'date' },
        { name: 'fechaUpdate', type: 'date' },
        { name: 'idEspecificacion', type: 'int' },
        { name: 'situacion', type: 'boolean' },
        { name: 'usuInsert', type: 'string' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEspecificacion',
            read: 'especificacions',
            update: 'uuEspecificacion',
            destroy: 'ddEspecificacion'
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
