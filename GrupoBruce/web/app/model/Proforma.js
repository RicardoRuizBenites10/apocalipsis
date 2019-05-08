Ext.define('GrupoBruce.model.Proforma', {
    extend: 'Ext.data.Model',
    idProperty: 'idProforma',
    fields: [
        { name: 'carroceria', type: 'string' },
        { name: 'cliente', type: 'string' },
        { name: 'fecha', type: 'date' },
        { name: 'idCarroceria', type: 'string' },
        { name: 'idCliente', type: 'string' },
        { name: 'idProforma', type: 'int' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiProforma',
            read: 'proformas',
            update: 'uuProforma',
            destroy: 'ddProforma'
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
