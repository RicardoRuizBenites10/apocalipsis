Ext.define('GrupoBruce.model.Plantilla', {
    extend: 'Ext.data.Model',
    idProperty: 'idEspecificacion',
    fields: [
        { name: 'especificacion', type: 'string' },
        { name: 'fechaInsert', type: 'date' },
        { name: 'fechaUpdate', type: 'date' },
        { name: 'idCarroceria', type: 'int' },
        { name: 'idEspecificacion', type: 'int' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiPlantilla',
            read: 'plantillas',
            update: 'uuPlantilla',
            destroy: 'ddPlantilla'
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
