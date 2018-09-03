Ext.define('GrupoBruce.model.TiempoContrato', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idTiempo',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTiempo', type: 'int' },
        { name: 'nroMeses', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ]
});
