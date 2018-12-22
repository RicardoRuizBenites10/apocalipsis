Ext.define('GrupoBruce.model.Rol', {
    extend: 'Ext.data.Model',
    alias: 'model.Mrol',

    idProperty: 'idRol',
    fields: [
        {name: 'denominacion', type: 'string'},
        {name: 'idRol', type: 'string'},
        {name: 'situacion', type: 'boolean'}
    ],

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiRol',
            read: 'rols',
            update: 'uuRol',
            destroy: 'ddRol'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'message',
            totalProperty: 'total'
        },
        writeer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
