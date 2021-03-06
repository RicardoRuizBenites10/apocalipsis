Ext.define('GrupoBruce.model.Concepto', {
    extend: 'Ext.data.Model',
    alias: 'model.Mconcepto',

    idProperty: 'idConcepto',
    fields: [
        {name: 'codPdt', type: 'string', defaultValue: ''},
        {name: 'descripcion', type: 'string'},
        {name: 'formula', type: 'string', defaultValue: ''},
        {name: 'idConcepto', type: 'string'},
        {name: 'idTconcepto', type: 'string'},
        {name: 'idTtrabajador', type: 'int'},
        {name: 'idTvariable', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true},
        {name: 'tconcepto', type: 'string'},
        {name: 'tvariable', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiConcepto',
            read: 'conceptos',
            update: 'uuConcepto',
            destroy: 'ddConcepto'
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
