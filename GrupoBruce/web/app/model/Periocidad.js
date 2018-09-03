Ext.define('GrupoBruce.model.Periocidad', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idPeriocidad',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idPeriocidad', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
