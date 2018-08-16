Ext.define('GrupoBruce.model.TipoEstudio', {
    extend: 'Ext.data.Model',
    idProperty: 'idTestudio',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTestudio', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
