Ext.define('GrupoBruce.model.Sucursal', {
    extend: 'Ext.data.Model',
    alias: 'model.Msucursal',
    
    idProperty: 'idSucursal',
    fields: [
        { name: 'direccion', type: 'string' },
        { name: 'idSucursal', type: 'string' },
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
            create: 'insertSucursal',
            update: 'updateSucursal',
            destroy : 'deleteSucursal'
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
