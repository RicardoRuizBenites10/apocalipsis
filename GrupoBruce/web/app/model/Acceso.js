Ext.define('GrupoBruce.model.Acceso', {
    extend: 'Ext.data.Model',
    idProperty: 'accesoIdId',
    fields: [
        { name: 'vistas', type: 'string' },
        { name: 'accesoIdId', reference: 'AccesoId', unique: true },
        { name: 'usuarioId', reference: 'Usuario' },
        { name: 'menuId', reference: 'Menu' }
    ]
});
