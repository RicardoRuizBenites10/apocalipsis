Ext.define('GrupoBruce.model.AsignacionDetalle', {
    extend: 'Ext.data.Model',
    alias: 'model.MasignacionDetalle',
    
    idProperty: 'idAequipo',
    fields: [
        {name: 'asignado', type: 'boolean'},
        {name: 'cantidad', type: 'int'},
        {name: 'fecha', type: 'date'},
        {name: 'idAequipo', type: 'int'},
        {name: 'idEinformatico', type: 'string'}
    ],

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
