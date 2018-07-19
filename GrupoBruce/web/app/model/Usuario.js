Ext.define('GrupoBruce.model.Usuario', {
    extend: 'Ext.data.Model',
    
    alias: 'model.usuario',
    
    fields: [
        { name: 'acceder', type: 'boolean' },
        { name: 'accesos', type: 'auto' },
        { name: 'clave', type: 'string' },
        { name: 'estado', type: 'boolean' },
        { name: 'idUsuario', type: 'string' },
        { name: 'trabajador', type: 'auto' },
        { name: 'usu', type: 'string' }
    ]
});
