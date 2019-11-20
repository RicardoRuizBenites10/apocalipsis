Ext.define('GrupoBruce.model.Contratista', {
    extend: 'Ext.data.Model',
    idProperty: 'idContratista',
    fields: [
        {name: 'correo', type: 'string'},
        {name: 'direccion', type: 'string'},
        {name: 'idContratista', type: 'string'},
        {name: 'nombre', type: 'string'},
        {name: 'situacion', type: 'boolean'},
        {name: 'telefono', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiContratista',
            read: 'contratistas',
            update: 'uuContratista',
            destroy: 'ddContratista'
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
