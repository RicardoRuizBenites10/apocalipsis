Ext.define('GrupoBruce.model.Asistencia', {
    extend: 'Ext.data.Model',
    alias: 'model.Masistencia',

    idProperty: 'idAsistencia',
    fields: [
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'marca1', type: 'date', dateFormat: 'h:i A'},
        {name: 'marca2', type: 'date', dateFormat: 'h:i A'},
        {name: 'marca3', type: 'date', dateFormat: 'h:i A'},
        {name: 'marca4', type: 'date', dateFormat: 'h:i A'},
        {name: 'marca5', type: 'date', dateFormat: 'h:i A'},
        {name: 'marca6', type: 'date', dateFormat: 'h:i A'},
        {name: 'marca7', type: 'date', dateFormat: 'h:i A'},
        {name: 'idAsistencia', type: 'string'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'anio', type: 'int'},
        {name: 'mes', type: 'int'},
        {name: 'dia', type: 'int'},
        {name: 'ausencia', type: 'int'},
        {name: 'asistio', type: 'boolean'},
        {name: 'hrsDscto', type: 'float'},
        {name: 'hrsExtra', type: 'float'},
        {name: 'stdExtra', type: 'boolean'},
        {name: 'procesado', type: 'boolean'},
        {name: 'trabajador', type: 'string'},
        {name: 'fechaTemp', type: 'date', dateFormat: 'c'}
    ],
    
    identifier: {
        type: 'sequential'
    },
    
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiAsistencia',
            read: 'asistencias',
            update: 'uuLAsistencia',
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
