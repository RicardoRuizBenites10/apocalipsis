Ext.define('GrupoBruce.model.Turno', {
    extend: 'Ext.data.Model',

    idProperty: 'idTurno',
    fields: [
        {name: 'actual', type: 'boolean', defaultValue: false},
        {name: 'dlbSemana', type: 'int'},
        {name: 'descripcion', type: 'string'},
        {name: 'idTurno', type: 'string'},
        {name: 'mlbSemana', type: 'int'}
    ],

    identifier: {
        type: 'sequential',
        prefix: '00'
    },

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiTurno',
            read: 'turnos',
            update: 'uuTurno',
            destroy: 'ddTurno'
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
