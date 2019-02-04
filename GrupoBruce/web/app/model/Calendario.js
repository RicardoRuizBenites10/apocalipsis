Ext.define('GrupoBruce.model.Calendario', {
    extend: 'Ext.data.Model',
    alias: 'model.Mcalendario',
    
    idProperty: 'fecha',
    fields: [
        {name: 'anio', type: 'int'},
        {name: 'dia', type: 'int'},
        {name: 'descripcion', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'horaEntrada', type: 'date', dateFormat: 'h:i A'},
        {name: 'horaSalida', type: 'date', dateFormat: 'h:i A'},
        {name: 'idDia', type: 'int'},
        {name: 'libre', type: 'boolean'},
        {name: 'mes', type: 'int'},
        {name: 'nroSemana', type: 'int'}
    ],
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiCalendario',
            read: 'calendarios',
            update: 'uuCalendario',
            destroy: 'ddCalendario'
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
