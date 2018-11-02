Ext.define('GrupoBruce.model.Asistencia', {
    extend: 'Ext.data.Model',
    alias: 'model.Masistencia',

    idProperty: 'idAsistencia',
    fields: [
        {name: 'fecha', type: 'date'},
        {name: 'hmarca', type: 'string'},
        {name: 'idAsistencia', type: 'string'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'trabajador', type: 'string'}
    ],

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiAsistencia',
            read: 'asistencias',
            update: 'uuAsistencia',
            destroy: 'ddAsistencia'
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
