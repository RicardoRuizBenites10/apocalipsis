Ext.define('GrupoBruce.model.Formacion', {
    extend: 'Ext.data.Model',
    alias: 'model.Mformacion',
    
    idProperty: 'idFormacion',
    fields: [
        { name: 'idTrabajador', type: 'string' },
        { name: 'idFormacion', type: 'int' },
        { name: 'descripcion', type: 'string' },
        { name: 'institucion', type: 'string' },
        { name: 'idTformacion', type: 'int' },
        { name: 'idEestudio', type: 'int' }
    ],
    
    identifier: 'sequential',
    
    proxy: {
        type: 'ajax',
        api: {
            create : 'insertFormacion',
            read: 'formacions',
            update: 'updateFormacion',
            destroy: 'deleteFormacion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
