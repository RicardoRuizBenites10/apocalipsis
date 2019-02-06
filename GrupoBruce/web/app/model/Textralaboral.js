Ext.define('GrupoBruce.model.Textralaboral', {
    extend: 'Ext.data.Model',
    alias: 'model.Mtextralaboral',

    idProperty: 'idTextralaboral',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'horaInicio', type: 'date', dateFormat: 'h:i A'},
        {name: 'horaSalida', type: 'date', dateFormat: 'h:i A'},
        {name: 'idActividad', type: 'int'},
        {name: 'idTextralaboral', type: 'string'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'idTtextra', type: 'int'},
        {name: 'trabajador', type: 'string'},
        {name: 'tipotextra', type: 'string'}
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
