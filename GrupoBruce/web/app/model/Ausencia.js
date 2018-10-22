Ext.define('GrupoBruce.model.Ausencia', {
    extend: 'Ext.data.Model',
    alias: 'model.Mausencia',
    
    idProperty: 'idAusencia',
    fields: [
        { name: 'detalle', type: 'string' },
        { name: 'fechaFin', type: 'date' },
        { name: 'fechaInicio', type: 'date' },
        { name: 'horaFin', type: 'date' },
        { name: 'horaInicio', type: 'date' },
        { name: 'idAusencia', type: 'int' },
        { name: 'idTausencia', type: 'int' },
        { name: 'idTmausencia', type: 'int' },
        { name: 'idTrabajador', type: 'string' }
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            read: 'ausencias',
            create: 'insertAusencia',
            update: 'updateAusencia',
            delete: 'deleteAusencia'
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
