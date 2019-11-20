Ext.define('GrupoBruce.model.EstadoObra', {
    extend: 'Ext.data.Model',
    alias: 'model.Mestadoobra',

    idProperty: 'idEobra',
    fields: [
        {name: 'detenido', type: 'boolean'},
        {name: 'ejecucion', type: 'boolean'},
        {name: 'entregadocli', type: 'boolean'},
        {name: 'entregadosto', type: 'boolean'},
        {name: 'idEobra', type: 'string'},
        {name: 'nombre', type: 'string'},
        {name: 'situacion', type: 'boolean'},
        {name: 'terminado', type: 'boolean'},
        {name: 'xllegar', type: 'boolean'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEstadoObra',
            read: 'estadoObras',
            update: 'uuEstadoObra',
            destroy: 'ddEstadoObra'
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
