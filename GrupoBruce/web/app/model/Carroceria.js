Ext.define('GrupoBruce.model.Carroceria', {
    extend: 'Ext.data.Model',
    idProperty: 'idCarroceria',
    fields: [
        { name: 'chasis', type: 'string' },
        { name: 'codigo', type: 'string' },
        { name: 'descripcion', type: 'string' },
        { name: 'falda', type: 'string' },
        { name: 'fecha', type: 'date' },
        { name: 'idCarfal', type: 'string' },
        { name: 'idCarroceria', type: 'int' },
        { name: 'idCartip', type: 'string' },
        { name: 'idChasis', type: 'int' },
        { name: 'situacion', type: 'boolean' },
        { name: 'tipo', type: 'string' }
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
