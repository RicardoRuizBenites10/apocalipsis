Ext.define('GrupoBruce.model.EspecificacionActividad', {
    extend: 'Ext.data.Model',
    idProperty: 'idActividad',
    fields: [
        {name: 'actividad', type: 'string'},
        {name: 'etapa', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idActividad', type: 'int'},
        {name: 'idEspecificacion', type: 'int'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiLEspecificacionActividad',
            read: 'especificacionActividads',
            update: 'uuLEspecificacionActividad',
            destroy: 'ddLEspecificacionActividad'
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
