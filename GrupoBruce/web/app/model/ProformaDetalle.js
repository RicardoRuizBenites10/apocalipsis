Ext.define('GrupoBruce.model.ProformaDetalle', {
    extend: 'Ext.data.Model',
    idProperty: 'idEspecificacion',
    fields: [
        { name: 'especificacion', type: 'string' },
        { name: 'fecha', type: 'date' },
        { name: 'idEspecificacion', type: 'int' },
        { name: 'idProforma', type: 'int' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiProformaDetalle',
            read: 'proformaDetalles',
            update: 'uuProformaDetalle',
            destroy: 'ddProformaDetalle'
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
