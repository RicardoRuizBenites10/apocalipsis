Ext.define('GrupoBruce.model.Comisionrp', {
    extend: 'Ext.data.Model',
    idProperty: 'idComisionrp',
    fields: [
        {name: 'comision', type: 'float'},
        {name: 'descripcion', type: 'string'},
        {name: 'fondo', type: 'float'},
        {name: 'idComisionrp', type: 'int'},
        {name: 'seguro', type: 'float'},
        {name: 'idRpensionario', type: 'string'}
    ]
});
