Ext.define('GrupoBruce.model.Genero', {
    extend: 'Ext.data.Model',
    alias: 'model.Mgenero',
    
    idProperty: 'idGenero',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idGenero', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'generoBySituacion',
            create: 'insertGenero',
            update: 'iupdateGenero',
            delete: 'deleteGenero'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    }
});
