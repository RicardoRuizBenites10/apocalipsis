Ext.define('GrupoBruce.model.EstadoEstudio', {
    extend: 'Ext.data.Model',
    idProperty: 'idEestudio',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idEestudio', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
