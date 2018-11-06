Ext.define('GrupoBruce.model.AsignacionEquipo', {
    extend: 'Ext.data.Model',
    alias: 'model.MasignacionEquipo',
    idProperty: 'idAequipo',
    fields: [
        {name: 'fecha', type: 'date'},
        {name: 'idAequipo', type: 'int'},
        {name: 'idAsignador', type: 'string'},
        {name: 'idRecepcionador', type: 'string'},
        {name: 'nomUsu', type: 'string'},
        {name: 'nroIp', type: 'string'},
        {name: 'pasUsu', type: 'string'}
    ],

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
