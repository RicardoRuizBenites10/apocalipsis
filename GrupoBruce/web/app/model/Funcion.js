Ext.define('GrupoBruce.model.Funcion', {
    extend: 'Ext.data.Model',
    idProperty: 'idFuncion',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'detalle', type: 'string' },
        { name: 'fecha', type: 'date' },
        { name: 'idFuncion', type: 'int' },
        { name: 'situacion', type: 'boolean' },
        { name: 'cargoId', reference: 'Cargo' }
    ]
});
