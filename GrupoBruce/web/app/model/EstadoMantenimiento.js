Ext.define('GrupoBruce.model.EstadoMantenimiento', {
    extend: 'Ext.data.Model',
    alias: 'model.MestadoMantenimiento',
    
    idProperty: 'idEstado',
    fields: [
        {name: 'idEstado', type: 'string'},
        {name: 'orden', type: 'int'},
        {name: 'descripcion', type: 'string'},
        {name: 'accion', type: 'string'},
        {name: 'solucionador', type: 'boolean'},
        {name: 'situacion', type: 'boolean'},
        {name: 'ultimo', type: 'boolean'},
        {name: 'idPrecede', type: 'string'}
    ],

    identifier: 'sequential',

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEstadoMantenimiento',
            read: 'estadosMantenimiento',
            update: 'uuEstadoMantenimiento',
            destroy: 'ddEstadoMantenimiento'
        },
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true
        }
    }
});
