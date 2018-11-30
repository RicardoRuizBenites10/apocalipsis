Ext.define('GrupoBruce.model.Usuario', {
    extend: 'Ext.data.Model',
    alias: 'model.Musuario',
    
    idProperty: 'idUsuario',
    fields: [
        { name: 'idUsuario', type: 'string' },
        { name: 'usu', type: 'string' },
        { name: 'clave', type: 'string' },
        { name: 'estado', type: 'boolean' },
        { name: 'idRol', type: 'string' }
    ],
    
    proxy: {
        type: 'json',
        api: {
            read: 'usuarios',
            create: 'insertUsuario',
            update: 'updateUsuario',
            delete: 'deleteUsuario'
        },
        reader: {
             type: 'json',
             root: 'data'
         }
    }
});
