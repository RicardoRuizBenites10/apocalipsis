Ext.define('GrupoBruce.model.Genero', {
    extend: 'Ext.data.Model',
    idProperty: 'idGenero',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idGenero', type: 'int' },
        { name: 'situacion', type: 'boolean' }

    ]
});
