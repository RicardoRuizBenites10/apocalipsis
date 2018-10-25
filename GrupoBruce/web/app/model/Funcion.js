Ext.define('GrupoBruce.model.Funcion', {
    extend: 'Ext.data.Model',
    alias: 'model.Mfuncion',
    
    idProperty: 'idFuncion',
    fields: [
        { name: 'detalle', type: 'string' },
        { name: 'nombre', type: 'string' },
        { name: 'situacion', type: 'boolean', defaultValue: true },
        { name: 'idArea', type: 'string' },
        { name: 'idCargo', type: 'int' },
        { name: 'idFuncion', type: 'int' }
    ],
    
    identifier: {
        type: 'sequential'
    },
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiFuncion',
            read: 'funcions',
            update: 'uuFuncion',
            destroy: 'ddFuncion'
        },
        reader: {
            type: 'json',
            rootProperty: 'data'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
