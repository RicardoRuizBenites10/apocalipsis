Ext.define('GrupoBruce.model.Usuario', {
    extend: 'Ext.data.Model',
    alias: 'model.usuario',
    
    idProperty: 'idUsuario',
    fields: [
        { name: 'idUsuario', type: 'string' },
        { name: 'usu', type: 'string' },
        { name: 'clave', type: 'string' },
        { name: 'estado', type: 'boolean' },
        { name: 'acceder', type: 'boolean' }
    ]
});
