Ext.define('GrupoBruce.model.ConceptoAsignado', {
    extend: 'Ext.data.Model',
    alias: 'model.MconceptoAsignado',

    idProperty: 'idCasignado',
    fields: [
        { name: 'fecha', type: 'date' },
        { name: 'idCasignado', type: 'string' },
        { name: 'idConcepto', type: 'string' },
        { name: 'idTtrabajador', type: 'int' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiConceptoAsignado',
            read: 'conceptosAsignado',
            update: 'uuConceptoAsignado',
            destroy: 'ddConceptoAsignado'
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