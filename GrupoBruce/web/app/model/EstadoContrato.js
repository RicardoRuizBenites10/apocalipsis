Ext.define('GrupoBruce.model.EstadoContrato', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idEcontrato',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idEcontrato', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'estadoContratos',
            create: 'insertEstadoContrato',
            update: 'updateEstadoContrato',
            delete: 'deleteEstadoContrato'
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
