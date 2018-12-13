Ext.define('GrupoBruce.model.Acceso', {
    extend: 'Ext.data.Model',
    alias: 'model.Macceso',

    idProperty: 'idMenu',
    fields: [
        {name: 'acceder', type: 'boolean'},
        {name: 'fechaUpdate', type: 'date'},
        {name: 'idMenu', type: 'string'},
        {name: 'idRol', type: 'string'}
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiAcceso',
            read: 'accesos',
            update: 'uuAcceso',
            destroy: 'ddAcceso'
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
