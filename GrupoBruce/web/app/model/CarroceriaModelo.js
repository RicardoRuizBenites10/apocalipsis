Ext.define('GrupoBruce.model.CarroceriaModelo', {
    extend: 'Ext.data.Model',
    idProperty: 'idCarmod',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idCarmod', type: 'string'},
        {name: 'nombre', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiCarroceriaModelo',
            read: 'carroceriaModelos',
            update: 'uuCarroceriaModelo',
            destroy: 'ddCarroceriaModelo'
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
