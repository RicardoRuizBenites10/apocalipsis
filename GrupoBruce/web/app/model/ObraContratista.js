Ext.define('GrupoBruce.model.ObraContratista', {
    extend: 'Ext.data.Model',
    alias: 'model.Mobracontratista',

    idProperty: 'idContratista',
    fields: [
        { name: 'contratista', type: 'string' },
        { name: 'etapa', type: 'string' },
        { name: 'idContratista', type: 'string' },
        { name: 'idEproceso', type: 'string' },
        { name: 'idObra', type: 'int' }
    ],

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiObraContratista',
            read: 'obraContratistas',
            update: 'uuObraContratista',
            destroy: 'ddObraContratista'
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
