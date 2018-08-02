Ext.define('GrupoBruce.model.TipoDocumento', {
    extend: 'Ext.data.Model',

    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'descripcion', type: 'string' },
        { name: 'idTdocumento', type: 'int' },
        { name: 'situacion', type: 'boolean' }

    ]
});
