Ext.define('GrupoBruce.model.ConceptoAsignado', {
    extend: 'Ext.data.Model',
    alias: 'model.MconceptoAsignado',

    idProperty: 'idConcepto',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'formula', type: 'string'},
        {name: 'idTplanilla', type: 'string'},
        {name: 'idConcepto', type: 'string'},
        {name: 'idTtrabajador', type: 'int'},
        {name: 'orden', type: 'int'}
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
