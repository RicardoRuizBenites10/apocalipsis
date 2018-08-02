Ext.define('GrupoBruce.model.TipoEstudio', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTestudio', type: 'int' },
        { name: 'situacion', type: 'boolean' }

    ]
});
