Ext.define('GrupoBruce.model.ProformaDetalle', {
    extend: 'Ext.data.Model',
    idProperty: 'idEspecificacion',
    fields: [
        {name: 'asignado', type: 'boolean', defaultValue: true},
        {name: 'categoria', type: 'string'},
        {name: 'especificacion', type: 'string'},
        {name: 'fechaUpdate', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idEspecificacion', type: 'int'},
        {name: 'idProforma', type: 'string'},
        {name: 'usuUpdate', type: 'string'},
        {name: 'wasstd', type: 'boolean', defaultValue: false}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLProformaDetalle',
            read: 'proformaDetalles',
            update: 'uuLProformaDetalle',
            destroy: 'ddLProformaDetalle'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            allowSingle: false,
            writeAllFields: true
        }
    }
});
