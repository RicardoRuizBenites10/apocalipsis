Ext.define('GrupoBruce.model.Ausencia', {
    extend: 'Ext.data.Model',
    alias: 'model.Mausencia',
    
    idProperty: 'idAusencia',
    fields: [
        { name: 'detalle', type: 'string' },
        { name: 'fechaFin', type: 'date', dateFormat: 'c' },
        { name: 'fechaInicio', type: 'date', dateFormat: 'c'},
        { name: 'horaFin', type: 'date', dateFormat: 'c' },
        { name: 'horaInicio', type: 'date', dateFormat: 'c' },
        { name: 'idAusencia', type: 'int' },
        { name: 'idTausencia', type: 'int' },
        { name: 'idTmausencia', type: 'int' },
        { name: 'idTrabajador', type: 'string' }
    ],
    
    identifier: {
        type: 'sequential'
    },
    
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
