Ext.define('GrupoBruce.model.Ecivil', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idEcivil',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idEcivil', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
