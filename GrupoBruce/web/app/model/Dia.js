Ext.define('GrupoBruce.model.Dia', {
    extend: 'Ext.data.Model',
    alias: 'model.Mdia',

    idProperty: 'idDia',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idDia', type: 'int'}
    ],
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiDia',
            read: 'dias',
            update: 'uuDia',
            destroy: 'ddDia'
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
