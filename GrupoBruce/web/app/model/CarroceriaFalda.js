Ext.define('GrupoBruce.model.CarroceriaFalda', {
    extend: 'Ext.data.Model',
    idProperty: 'idCarfal',
    fields: [
        {name: 'nombre', type: 'string'},
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idCarfal', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
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
