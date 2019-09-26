Ext.define('GrupoBruce.model.EtapaProceso', {
    extend: 'Ext.data.Model',
    alias: 'model.Metapaproceso',

    idProperty: 'idEproceso',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idEproceso', type: 'string'},
        {name: 'idSupeproceso', type: 'string'},
        {name: 'leaf', type: 'boolean'},
        {name: 'nivel', type: 'int'},
        {name: 'orden', type: 'int'},
        {name: 'pasaBus', type: 'boolean', defaultValue: true},
        {name: 'situacion', type: 'boolean', defaultValue: true}
    ],

    identifier: {
        type: 'sequential',
        prefix: '00'
    },
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEtapaProceso',
            read: 'etapaProcesos',
            update: 'uuEtapaProceso',
            destroy: 'ddEtapaProceso'
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
