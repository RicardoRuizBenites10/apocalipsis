Ext.define('GrupoBruce.model.Area', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idArea',
    fields: [
        { name: 'idArea', type: 'int' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ]
});
