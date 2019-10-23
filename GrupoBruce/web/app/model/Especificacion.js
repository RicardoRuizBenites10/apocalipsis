Ext.define('GrupoBruce.model.Especificacion', {
    extend: 'Ext.data.Model',
    idProperty: 'idEspecificacion',
    fields: [
        {name: 'categoria', type: 'string'},
        {name: 'descripcion', type: 'string'},
        {name: 'fechaInsert', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'fechaUpdate', type: 'date', dateFormat: 'c', defaultValue: new Date()},
        {name: 'idEspecificacion', type: 'int'},
        {name: 'idEcategoria', type: 'string'},
        {name: 'situacion', type: 'boolean'},
        {name: 'usaActividad', type: 'boolean'},
        {name: 'usuInsert', type: 'string'},
        {name: 'usuUpdate', type: 'string'}
    ],

    identifier: 'sequential',
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiEspecificacion',
            read: 'especificacions',
            update: 'uuEspecificacion',
            destroy: 'ddEspecificacion'
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
