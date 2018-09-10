Ext.define('GrupoBruce.model.TipoDocumento', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idTdocumento',
    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'descripcion', type: 'string' },
        { name: 'descripcionAbreviada', type: 'string' },
        { name: 'idTdocumento', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ]
});
