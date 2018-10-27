Ext.define('GrupoBruce.model.Empresa', {
    extend: 'Ext.data.Model',
    alias: 'model.Mempresa',
    
    idProperty: 'idEmpresa',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idEmpresa', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    identifier: {
        type: 'sequential',
        prefix: '00'
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
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
