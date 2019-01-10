Ext.define('GrupoBruce.model.Empresa', {
    extend: 'Ext.data.Model',
    alias: 'model.Mempresa',
    
    idProperty: 'idEmpresa',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'ruc', type: 'string' },
        { name: 'idEmpresa', type: 'string' },
        { name: 'logo', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    identifier: {
        type: 'sequential'
    },
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEmpresa',
            read: 'empresaBySituacion',
            update: 'uuEmpresa',
            destroy: 'ddEmpresa'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
