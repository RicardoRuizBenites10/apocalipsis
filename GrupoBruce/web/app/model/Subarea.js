Ext.define('GrupoBruce.model.Subarea', {
    extend: 'Ext.data.Model',
    idProperty: 'idSubarea',
    fields: [
        { name: 'idSubarea', type: 'int' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean' },
        { name: 'areaId', reference: 'GrupoBruce.model.Area', type: 'int' }
    ]
});
