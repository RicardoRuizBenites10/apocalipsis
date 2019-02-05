Ext.define('GrupoBruce.model.EtapaProceso', {
    extend: 'Ext.data.Model',

    idProperty: 'idEproceso',
    fields: [
        {name: 'descripcion', type: 'string'},
        {name: 'idEproceso', type: 'int'},
        {name: 'orden', type: 'int'},
        {name: 'situacion', type: 'boolean'}
    ],

    identifier: 'sequential',
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
