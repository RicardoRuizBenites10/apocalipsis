Ext.define('GrupoBruce.model.CarroceriaTipo', {
    extend: 'Ext.data.Model',
    idProperty: 'idCartip',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idCarmod', type: 'string'},
        {name: 'idCartip', type: 'string'},
        {name: 'modelo', type: 'string'},
        {name: 'nombre', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
    ],
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiCarroceriaTipo',
            read: 'carroceriaTipos',
            update: 'uuCarroceriaTipo',
            destroy: 'ddCarroceriaTipo'
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
