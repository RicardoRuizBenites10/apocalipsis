Ext.define('GrupoBruce.model.Usuario', {
    extend: 'Ext.data.Model',
    
    alias: 'model.usuario',
    
    fields: [
        { name: 'idUsuario', type: 'string' },
        { name: 'trabajador', type: 'string' },
        { name: 'usu', type: 'string' },
        { name: 'clave', type: 'string' },
        { name: 'estado', type: 'boolean' },
        { name: 'acceder', type: 'boolean' },
        { name: 'accesos', type: 'string' },
        { name: 'trabajadorId', reference: 'Trabajador', unique: true }
    ]
});
