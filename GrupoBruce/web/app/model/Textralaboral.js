Ext.define('GrupoBruce.model.Textralaboral', {
    extend: 'Ext.data.Model',
    alias: 'model.Mtextralaboral',

    idProperty: 'idTextralaboral',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date'},
        {name: 'horaInicio', type: 'date'},
        {name: 'horaSalida', type: 'date'},
        {name: 'idActividad', type: 'int'},
        {name: 'idTextralaboral', type: 'string'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'idTtextra', type: 'int'},
        {name: 'trabajador', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTextralaboral',
            read: 'textralaborals',
            update: 'uuTextralaboral',
            destroy: 'ddTextralaboral'
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
