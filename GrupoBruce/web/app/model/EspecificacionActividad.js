Ext.define('GrupoBruce.model.EspecificacionActividad', {
    extend: 'Ext.data.Model',
    idProperty: 'idActividad',
    fields: [
        {name: 'actividad', type: 'string'},
        {name: 'etapa', type: 'string'},
        {name: 'fecha', type: 'date'},
        {name: 'idActividad', type: 'int'},
        {name: 'idEspecificacion', type: 'int'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEspecificacionActividad',
            read: 'especificacionActividads',
            update: 'uuEspecificacionActividad',
            destroy: 'ddEspecificacionActividad'
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
