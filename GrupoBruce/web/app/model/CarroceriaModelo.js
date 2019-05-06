Ext.define('GrupoBruce.model.CarroceriaModelo', {
    extend: 'Ext.data.Model',
    idProperty: 'idCarmod',
    fields: [
        {name: 'codigo', type: 'string'},
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date'},
        {name: 'idCarmod', type: 'string'},
        {name: 'situacion', type: 'boolean'}
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
