Ext.define('GrupoBruce.model.Archivo', {
    extend: 'Ext.data.Model',
    alias: 'model.Marchivo',

    idProperty: 'idArchivo',
    fields: [
        {name: 'idDirectorio', type: 'int'},
        {name: 'idArchivo', type: 'int'},
        {name: 'nombre', type: 'string'},
        {name: 'afterB64', type: 'string'},
        {name: 'beforeB64', type: 'string'}
    ],

    identifier: {
        type: 'sequential'
    },

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiArchivo',
            read: 'asistencias',
            update: 'uuArchivo',
            destroy: 'ddArchivo'
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
