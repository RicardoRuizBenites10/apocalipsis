Ext.define('GrupoBruce.model.Proforma', {
    extend: 'Ext.data.Model',
    idProperty: 'idProforma',
    fields: [
        {name: 'anio', type: 'int', defaultValue: (new Date()).getFullYear()},
        {name: 'carroceria', type: 'string'},
        {name: 'cliente', type: 'string'},
        {name: 'fechaInsert', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'fechaUpdate', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idCarroceria', type: 'string'},
        {name: 'idCliente', type: 'string'},
        {name: 'idProforma', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true},
        {name: 'usuInsert', type: 'string'},
        {name: 'usuUpdate', type: 'string'}
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
