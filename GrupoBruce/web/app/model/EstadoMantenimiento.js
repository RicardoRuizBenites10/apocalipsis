Ext.define('GrupoBruce.model.EstadoMantenimiento', {
    extend: 'Ext.data.Model',
    alias: 'model.MestadoMantenimiento',
    idProperty: 'idEmantenimiento',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idEmantenimiento', type: 'string'},
        {name: 'orden', type: 'int'},
        {name: 'solucionador', type: 'boolean'},
        {name: 'idPosterior', type: 'string'},
        {name: 'ultimo', type: 'boolean'},
        {name: 'situacion', type: 'boolean'}
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
