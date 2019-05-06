Ext.define('GrupoBruce.model.MaterialSubfamilia', {
    extend: 'Ext.data.Model',
    idProperty: 'idSubfamilia',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'fecha', type: 'date' },
        { name: 'idFamilia', type: 'int' },
        { name: 'idSubfamilia', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMaterialSubfamilia',
            read: 'materialSubfamilias',
            update: 'uuMaterialSubfamilia',
            destroy: 'ddMaterialSubfamilia'
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
