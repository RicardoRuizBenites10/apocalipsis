Ext.define('GrupoBruce.model.PrestamoPago', {
    extend: 'Ext.data.Model',
    alias: 'model.MprestamoPago',

    idProperty: 'idPpago',
    fields: [
        { name: 'fecha', type: 'date' },
        { name: 'idPpago', type: 'string' },
        { name: 'idPrestamo', type: 'string' },
        { name: 'monto', type: 'float' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiPrestamoPago',
            read: 'prestamosPago',
            update: 'uuPrestamoPago',
            destroy: 'ddPrestamoPago'
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
