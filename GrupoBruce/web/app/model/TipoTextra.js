Ext.define('GrupoBruce.model.TipoTextra', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoTextra',

    idProperty: 'idTtextra',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idTtextra', type: 'int'},
        {name: 'situacion', type: 'boolean'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTipoTextra',
            read: 'tipoTextras',
            update: 'uuTipoTextra',
            destroy: 'ddTipoTextra'
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
