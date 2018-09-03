Ext.define('GrupoBruce.model.TipoPeriodo', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idTperiodo',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTperiodo', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
