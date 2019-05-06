Ext.define('GrupoBruce.model.Material', {
    extend: 'Ext.data.Model',
    idProperty: 'idMaterial',
    fields: [
        { name: 'autoparte', type: 'boolean' },
        { name: 'cantIngreso', type: 'float' },
        { name: 'cantSalida', type: 'float' },
        { name: 'familia', type: 'string' },
        { name: 'idEmpresa', type: 'string' },
        { name: 'idFamilia', type: 'int' },
        { name: 'idMaterial', type: 'int' },
        { name: 'idSubfamilia', type: 'int' },
        { name: 'idSucursal', type: 'string' },
        { name: 'idUsuario', type: 'string' },
        { name: 'nombre', type: 'string' },
        { name: 'precio', type: 'float' },
        { name: 'segCalidad', type: 'boolean' },
        { name: 'stock', type: 'float' },
        { name: 'stockMaximo', type: 'float' },
        { name: 'stockMinimo', type: 'float' },
        { name: 'subfamilia', type: 'string' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMaterial',
            read: 'materials',
            update: 'uuMaterial',
            destroy: 'ddMaterial'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
