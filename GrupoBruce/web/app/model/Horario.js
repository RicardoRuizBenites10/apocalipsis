Ext.define('GrupoBruce.model.Horario', {
    extend: 'Ext.data.Model',
    alias: 'model.Mhorario',

    idProperty: 'idTurno',
    fields: [
        {name: 'horaEntrada', type: 'date', dateFormat: 'h:i A'},
        {name: 'horaSalida', type: 'date', dateFormat: 'h:i A'},
        {name: 'idDia', type: 'int'},
        {name: 'idTurno', type: 'string'},
        {name: 'libre', type: 'boolean'},
        {name: 'refrigerio', type: 'boolean'},
        {name: 'situacion', type: 'boolean', defaultValue: true},
        {name: 'dia', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiHorario',
            read: 'horarios',
            update: 'uuHorario',
            destroy: 'ddHorario'
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
