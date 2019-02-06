Ext.define('GrupoBruce.model.Actividad', {
    extend: 'Ext.data.Model',
    alias: 'model.Mactividad',
    
    idProperty: "idActividad",
    fields: [
        {name: 'duracion', type: 'float'},
        {name: 'fecha', type: 'date'},
        {name: 'idActividad', type: 'string'},
        {name: 'idEproceso', type: 'int'},
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
