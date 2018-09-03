Ext.define('GrupoBruce.model.EstadoContrato', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idEcontrato',
    fields: [
        { name: 'descripcion', type: 'boolean' },
        { name: 'idEcontrato', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
