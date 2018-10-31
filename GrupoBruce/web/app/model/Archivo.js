Ext.define('GrupoBruce.model.Archivo', {
    extend: 'Ext.data.Model',
    alias: 'model.Marchivo',

    idProperty: 'idFile',
    fields: [
        {name: 'extension', type: 'string'},
        {name: 'idDirectorio', type: 'int'},
        {name: 'idFile', type: 'int'},
        {name: 'nombre', type: 'string'},
        {name: 'fileB64', type: 'string'}
    ],

    proxy: {
        type: 'ajax',
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
