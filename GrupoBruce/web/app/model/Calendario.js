Ext.define('GrupoBruce.model.Calendario', {
    extend: 'Ext.data.Model',
    alias: 'model.Mcalendario',

    fields: [
        {name: 'anio', type: 'int'},
        {name: 'dia', type: 'int'},
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
            create: 'iiCalenario',
            read: 'calendarios',
            update: 'uuCalenario',
            destroy: 'ddCalenario'
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
