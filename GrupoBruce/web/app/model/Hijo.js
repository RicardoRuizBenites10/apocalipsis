Ext.define('GrupoBruce.model.Hijo', {
    extend: 'Ext.data.Model',
    alias: 'model.Mhijo',
    
    idProperty: 'idHijo',
    fields: [
        { name: 'idTrabajador', type: 'string' },
        { name: 'dni', type: 'string' },
        { name: 'idHijo', type: 'int' },
        { name: 'nacimiento', type: 'date' },
        { name: 'nombres', type: 'string' },
        { name: 'idGenero', type:'int' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'hijos',
            create: 'insertHijo',
            update: 'iupdateHijo',
            delete: 'deleteHijo'
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
