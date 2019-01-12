Ext.define('GrupoBruce.model.Marca', {
    extend: 'Ext.data.Model',
    alias: 'model.Mmarca',
    
    idProperty: 'idMarca',
    fields: [
        { name: 'fecha', type: 'date' },
        { name: 'hmarca', type: 'string' },
        { name: 'idAsistencia', type: 'string' },
        { name: 'idMarca', type: 'string' },
        { name: 'idTrabajador', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    identifier: 'sequential',
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMarca',
            read: 'marcas',
            update: 'uuMarca',
            destroy: 'ddMarca'
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
