Ext.define('GrupoBruce.model.Hijo', {
    extend: 'Ext.data.Model',
    alias: 'model.Mhijo',

    idProperty: 'idHijo',
    fields: [
        {name: 'idTrabajador', type: 'string'},
        {name: 'idHijo', type: 'int'},
        {name: 'dni', type: 'string'},
        {name: 'nacimiento', type: 'date', dateFormat: 'c'},
        {name: 'nombres', type: 'string'},
        {name: 'idGenero', type: 'int'}
    ],

    identifier: {
        type: 'sequential'
    },

    proxy: {
        type: 'ajax',
        api: {
            read: 'hijos',
            create: 'insertHijo',
            update: 'updateHijo',
            destroy : 'deleteHijo'
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
