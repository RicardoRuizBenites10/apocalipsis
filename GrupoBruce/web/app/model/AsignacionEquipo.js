Ext.define('GrupoBruce.model.AsignacionEquipo', {
    extend: 'Ext.data.Model',
    alias: 'model.MasignacionEquipo',
    idProperty: 'idAequipo',
    fields: [
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'idAequipo', type: 'string'},
        {name: 'estado', type: 'boolean'},
        {name: 'idAsignador', type: 'string'},
        {name: 'idRecepcionador', type: 'string'},
        {name: 'nomUsu', type: 'string'},
        {name: 'nroIp', type: 'string'},
        {name: 'pasUsu', type: 'string'}
    ],
    
    identifier: 'sequential',

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiAsignacionEquipo',
            read: 'asignacionsEquipo',
            update: 'uuAsignacionEquipo',
            destroy: 'ddAsignacionEquipo'
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
