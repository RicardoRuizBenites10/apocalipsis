Ext.define('GrupoBruce.model.Usuario', {
    extend: 'Ext.data.Model',
    alias: 'model.Musuario',

    idProperty: 'idUsuario',
    fields: [
        {name: 'idUsuario', type: 'string'},
        {name: 'usu', type: 'string'},
        {name: 'clave', type: 'string'},
        {name: 'estado', type: 'boolean'},
        {name: 'idRol', type: 'string'}
    ],

    proxy: {
        type: 'ajax',
        api: {
            read: 'usuarios',
            create: 'iiUsuario',
            update: 'uuUsuario',
            delete: 'ddUsuario'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
