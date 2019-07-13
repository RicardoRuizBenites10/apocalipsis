Ext.define('GrupoBruce.model.MaterialFamilia', {
    extend: 'Ext.data.Model',
    idProperty: 'idFamilia',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idFamilia', type: 'int'},
        {name: 'situacion', type: 'boolean'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMaterialFamilia',
            read: 'materialFamilias',
            update: 'uuMaterialFamilia',
            destroy: 'ddMaterialFamilia'
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
