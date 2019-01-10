Ext.define('GrupoBruce.model.Sucursal', {
    extend: 'Ext.data.Model',
    alias: 'model.Msucursal',
    
    idProperty: 'idSucursal',
    fields: [
        { name: 'direccion', type: 'string' },
        { name: 'idSucursal', type: 'string' },
        { name: 'telefono', type: 'string' },
        { name: 'telefono2', type: 'string' },
        { name: 'situacion', type: 'boolean' },
        { name:'idEmpresa', type: 'string' }
    ],

    identifier: {
        type: 'sequential'
    },

    proxy: {
        type: 'ajax',
        api: {
            read: 'sucursals',
            create: 'iiSucursal',
            update: 'uuSucursal',
            destroy : 'ddSucursal'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
    
});
