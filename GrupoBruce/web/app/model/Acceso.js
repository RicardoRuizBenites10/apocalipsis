Ext.define('GrupoBruce.model.Acceso', {
    extend: 'Ext.data.Model',
    idProperty: 'accesoIdId',
    fields: [
        { name: 'vistas', type: 'string' },
        { name: 'accesoIdId', reference: 'GrupoBruce.model.AccesoId', unique: true },
        { name: 'usuarioId', reference: 'GrupoBruce.model.Usuario', type: 'string' },
        { name: 'menuId', reference: 'GrupoBruce.model.Menu', type: 'int' }
    ]
});
