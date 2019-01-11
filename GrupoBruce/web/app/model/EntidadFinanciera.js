Ext.define('GrupoBruce.model.EntidadFinanciera', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idEfinanciera',
    fields: [
        { name: 'codigo', type: 'string' },
        { name: 'idEfinanciera', type: 'string' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    identifier: 'sequential',
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEntidadFinanciera',
            read: 'entidadFinancieraBySituacion',
            update: 'uuEntidadFinanciera',
            destroy: 'ddEntidadFinanciera'
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
