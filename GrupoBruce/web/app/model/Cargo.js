Ext.define('GrupoBruce.model.Cargo', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idCargo',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'fecha', type: 'date' },
        { name: 'idCargo', type: 'int' },
        { name: 'situacion', type: 'boolean' },
        { name: 'subareaId', reference: 'GrupoBruce.model.Subarea', type: 'int' }
    ]
});
