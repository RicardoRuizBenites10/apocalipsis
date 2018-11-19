Ext.define('GrupoBruce.model.AsignacionDetalle', {
    extend: 'Ext.data.Model',
    alias: 'model.MasignacionDetalle',
    
    idProperty: 'idAdetalle',
    fields: [
        {name: 'asignado', type: 'boolean'},
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'fechaAsignado', type: 'date', dateFormat: 'c'},
        {name: 'idAequipo', type: 'string'},
        {name: 'idEinformatico', type: 'string'},
        {name: 'idAdetalle', type: 'string'},
        {name: 'einformatico', type: 'string'}
    ],
    identifier: 'sequential',

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiAsignacionDetalle',
            read: 'asignacionsDetalle',
            update: 'uuAsignacionDetalle',
            destroy: 'ddAsignacionDetalle'
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
