Ext.define('GrupoBruce.model.TipoVariable', {
    extend: 'Ext.data.Model',
    alias: 'model.MtipoVariable',

    idProperty: 'idTipo',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idTipo', type: 'string'},
        {name: 'situacion', type: 'boolean', defaultValue: true}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTipoVariable',
            read: 'tiposVariable',
            update: 'uuTipoVariable',
            destroy: 'ddTipoVariable'
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
