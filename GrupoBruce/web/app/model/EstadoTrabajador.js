Ext.define('GrupoBruce.model.EstadoTrabajador', {
    extend: 'Ext.data.Model',
    idProperty: 'idEtrabajador',
    fields: [
        { name: 'codigo', type: 'int' },
        { name: 'descripcion', type: 'string' },
        { name: 'idEtrabajador', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
