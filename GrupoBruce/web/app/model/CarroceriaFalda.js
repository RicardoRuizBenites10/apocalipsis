Ext.define('GrupoBruce.model.CarroceriaFalda', {
    extend: 'Ext.data.Model',
    idProperty: 'idCarfal',
    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'descripcion', type: 'string' },
        { name: 'fecha', type: 'date' },
        { name: 'idCarfal', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiCarroceriaFalda',
            read: 'carroceriaFaldas',
            update: 'uuCarroceriaFalda',
            destroy: 'ddCarroceriaFalda'
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
