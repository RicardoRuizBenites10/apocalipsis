Ext.define('GrupoBruce.model.Requerimiento', {
    extend: 'Ext.data.Model',
    alias: 'model.Mrequerimiento',
    
    idProperty: 'idActividad',
    fields: [
        {name: 'extornado', type: 'boolean'},
        {name: 'fechaGenerado', type: 'date'},
        {name: 'fechaProgramado', type: 'date'},
        {name: 'idActividad', type: 'int'},
        {name: 'idEspecificacion', type: 'int'},
        {name: 'idObra', type: 'int'},
        {name: 'idRequerimiento', type: 'int'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'idUsuario', type: 'string'}
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLRequerimiento',
            read: 'requerimientos',
            update: 'uuLRequerimiento',
            destroy: 'ddLRequerimiento'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            allowSingle: false,
            writeAllFields: true
        }
    }
});