Ext.define('GrupoBruce.model.Proceso', {
    extend: 'Ext.data.Model',
    alias: 'model.Mproceso',
    
    idProperty: 'idProceso',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'estado', type: 'boolean' },
        { name: 'fecha', type: 'date' , dateFormat: 'c'},
        { name: 'idProceso', type: 'string' },
        { name: 'nombre', type: 'string' }
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiProceso',
            read: 'procesos',
            update: 'uuProceso',
            destroy: 'ddProceso'
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
