Ext.define('GrupoBruce.model.TipoMantenimiento', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoMantenimiento',
    idProperty: 'idTmantenimiento',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTmantenimiento', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTipoMantenimiento',
            read: 'tiposMantenimiento',
            update: 'uuTipoMantenimiento',
            destroy: 'ddTipoMantenimiento'
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
