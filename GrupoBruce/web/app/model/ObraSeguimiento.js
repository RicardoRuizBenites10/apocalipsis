Ext.define('GrupoBruce.model.ObraSeguimiento', {
    extend: 'Ext.data.Model',
    alias: 'model.Mobraseguimiento',

    idProperty: 'idEproceso',
    fields: [
        {name: 'etapa', type: 'string'},
        {name: 'fin', type: 'date'},
        {name: 'finProgramado', type: 'date'},
        {name: 'idEproceso', type: 'string'},
        {name: 'idObra', type: 'int'},
        {name: 'idUsuario', type: 'string'},
        {name: 'inicio', type: 'date'},
        {name: 'inicioProgramado', type: 'date'},
        {name: 'observacion', type: 'string'}
    ],

    identifier: 'sequential',

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiObraSeguimiento',
            read: 'obraSeguimientos',
            update: 'uuObraSeguimiento',
            destroy: 'ddObraSeguimiento'
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
