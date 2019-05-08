Ext.define('GrupoBruce.model.Carroceria', {
    extend: 'Ext.data.Model',
    idProperty: 'idCarroceria',
    fields: [
        {name: 'chasis', type: 'string'},
        {name: 'codigo', type: 'string'},
        {name: 'descripcion', type: 'string'},
        {name: 'falda', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idCarfal', type: 'string'},
        {name: 'idCarroceria', type: 'string'},
        {name: 'idCarmod', type: 'string'},
        {name: 'idCartip', type: 'string'},
        {name: 'idChapro', type: 'string'},
        {name: 'idChasis', type: 'int'},
        {name: 'proveedor', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true},
        {name: 'subtipo', type: 'string'},
        {name: 'tipo', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiCarroceria',
            read: 'carrocerias',
            update: 'uuCarroceria',
            destroy: 'ddCarroceria'
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
