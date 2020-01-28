Ext.define('GrupoBruce.model.ObraSeguimiento', {
    extend: 'Ext.data.Model',
    alias: 'model.Mobraseguimiento',

    idProperty: 'idEproceso',
    fields: [
        {name: 'etapa', type: 'string'},
        {name: 'fin', type: 'date', dateFormat: 'c'},
        {name: 'finProgramado', type: 'date', dateFormat: 'c'},
        {name: 'idEproceso', type: 'string'},
        {name: 'idObra', type: 'int'},
        {name: 'idUsuario', type: 'string'},
        {name: 'inicio', type: 'date', dateFormat: 'c'},
        {name: 'inicioProgramado', type: 'date', dateFormat: 'c'},
        {name: 'observacion', type: 'string'},
        {name: 'orden', type: 'int'},
        {name: 'ubicacion', type: 'boolean'}
    ],

    identifier: 'sequential',

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLObraSeguimiento',
            read: 'obraSeguimientos',
            update: 'uuLObraSeguimiento',
            destroy: 'ddLObraSeguimiento'
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
