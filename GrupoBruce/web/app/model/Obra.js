Ext.define('GrupoBruce.model.Obra', {
    extend: 'Ext.data.Model',
    idProperty: 'idObra',
    fields: [
        { name: 'cliente', type: 'string' },
        { name: 'fecha', type: 'date' },
        { name: 'fechaFin', type: 'date' },
        { name: 'fechaInicio', type: 'date' },
        { name: 'idCliente', type: 'string' },
        { name: 'idObra', type: 'int' },
        { name: 'idObrtip', type: 'int' },
        { name: 'idProforma', type: 'int' },
        { name: 'nombre', type: 'string' },
        { name: 'tipo', type: 'string' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiObra',
            read: 'obras',
            update: 'uuObra',
            destroy: 'ddObra'
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
