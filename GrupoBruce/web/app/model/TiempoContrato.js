Ext.define('GrupoBruce.model.TiempoContrato', {
    extend: 'Ext.data.Model',
    
    idProperty: 'idTiempo',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTiempo', type: 'int' },
        { name: 'nroMeses', type: 'int' },
        { name: 'situacion', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'tiempoContratos',
            create: 'insertTiempoContrato',
            update: 'updateTiempoContrato',
            delete: 'deleteTiempoContrato'
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
