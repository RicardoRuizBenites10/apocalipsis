Ext.define('GrupoBruce.model.Sucursal', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idSucursal',
    fields: [
        { name: 'direccion', type: 'string' },
        { name: 'idSucursal', type: 'string' },
        { name: 'situacion', type: 'boolean' },
        { name:'idEmpresa', type: 'string' }
    ]
});
