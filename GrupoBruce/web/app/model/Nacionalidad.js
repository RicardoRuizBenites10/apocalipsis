Ext.define('GrupoBruce.model.Nacionalidad', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idNacionalidad',
    fields: [
        { name: 'codigo', type: 'int' },
        { name: 'descripcion', type: 'string' },
        { name: 'idNacionalidad', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'nacionalidadBySituacion',
            create: 'insertNacionalidad',
            update: 'updateNacionalidad',
            delete: 'deleteNacionalidad'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
    
});
