Ext.define('GrupoBruce.model.Plantilla', {
    extend: 'Ext.data.Model',
    idProperty: 'idEspecificacion',
    fields: [
        {name: 'asignado', type: 'boolean', defaultValue: true},
        {name: 'especificacion', type: 'string'},
        {name: 'fechaUpdate', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idCarroceria', type: 'string'},
        {name: 'idEspecificacion', type: 'int'},
        {name: 'usuUpdate', type: 'string'}
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
