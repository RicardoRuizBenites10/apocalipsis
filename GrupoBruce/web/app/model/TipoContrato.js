Ext.define('GrupoBruce.model.TipoContrato', {
    extend: 'Ext.data.Model',
    idProperty: 'idTcontrato',
    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'idTcontrato', type: 'int' },
        { name: 'situacion', type: 'boolean' },
        { name: 'tipo', type: 'string' }
    ]
});
