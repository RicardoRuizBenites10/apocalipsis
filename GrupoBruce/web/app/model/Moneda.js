Ext.define('GrupoBruce.model.Moneda', {
    extend: 'Ext.data.Model',

    idProperty: 'idMoneda',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idMoneda', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMoneda',
            read: 'monedas',
            update: 'uuMoneda',
            destroy: 'ddMoneda'
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
