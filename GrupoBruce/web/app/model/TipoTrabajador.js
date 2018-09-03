Ext.define('GrupoBruce.model.TipoTrabajador', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idTtrabajador',
    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'descripcion', type: 'string' },
        { name: 'idTtrabajador', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
