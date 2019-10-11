Ext.define('GrupoBruce.model.Actividad', {
    extend: 'Ext.data.Model',
    alias: 'model.Mactividad',
    
    idProperty: "idActividad",
    fields: [
        {name: 'duracion', type: 'float'},
        {name: 'etapa', type: 'string'},
        {name: 'fecha', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idActividad', type: 'int'},
        {name: 'idEproceso', type: 'string'},
        {name: 'idMoneda', type: 'string'},
        {name: 'usaMaterial', type: 'boolean'},
        {name: 'idUsuario', type: 'string'},
        {name: 'nombre', type: 'string'},
        {name: 'precio', type: 'float'},
        {name: 'situacion', type: 'boolean'}
    ],
    
    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiActividad',
            read: 'actividads',
            update: 'uuActividad',
            destroy: 'ddActividad'
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
