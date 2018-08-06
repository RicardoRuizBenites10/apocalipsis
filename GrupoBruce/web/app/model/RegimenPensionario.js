Ext.define('GrupoBruce.model.RegimenPensionario', {
    extend: 'Ext.data.Model',
    idProperty: 'idRpensionario',
    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'cuspp', type: 'boolean' },
        { name: 'descripcion', type: 'string' },
        { name: 'idRpensionario', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
