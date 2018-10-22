Ext.define('GrupoBruce.model.TiempoAusencia', {
    extend: 'Ext.data.Model',
    alias: 'model.MtiempoAusencia',
    
    idProperty: 'idTmausencia',
    fields: [
        { name: 'descripcion', type: 'string' },
        { name: 'idTmausencia', type: 'int' },
        { name: 'situacion', type: 'boolean' },
        { name: 'horas', type: 'boolean' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'tiemposAusencia',
            create: 'insertTiempoAusencia',
            update: 'updateTiempoAusencia',
            delete: 'deleteTiempoAusencia'
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
