Ext.define('GrupoBruce.model.EspecificacionCategoria', {
    extend: 'Ext.data.Model',
    alias: 'model.Mespecificacioncategoria',
    
    idProperty: 'idEcategoria',
    fields: [
        { name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date() },
        { name: 'fechaUpdate', type: 'date', dateFormat: 'c' },
        { name: 'idEcategoria', type: 'string' },
        { name: 'idSupecategoria', type: 'string' },
        { name: 'leaf', type: 'boolean' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean', defaultValue: true }
    ],
    
    identifier: {
        type: 'sequential',
        prefix: '00'
    },
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEspecificacionCategoria',
            read: 'especificacionCategorias',
            update: 'uuEspecificacionCategoria',
            destroy: 'ddEspecificacionCategoria'
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
