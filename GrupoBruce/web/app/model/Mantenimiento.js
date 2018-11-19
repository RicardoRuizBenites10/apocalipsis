Ext.define('GrupoBruce.model.Mantenimiento', {
    extend: 'Ext.data.Model',
    alias: 'model.Mmantenimiento',
    idProperty: 'idMantenimiento',
    fields: [
        {name: 'atendido', type: 'boolean'},
        {name: 'costo', type: 'float'},
        {name: 'fecha', type: 'date'},
        {name: 'fechaAtendido', type: 'date'},
        {name: 'fechaProgramada', type: 'date'},
        {name: 'idAequipo', type: 'string'},
        {name: 'idMantenimiento', type: 'string'},
        {name: 'idTmantenimiento', type: 'string'},
        {name: 'idEmantenimiento', type: 'string'},
        {name: 'observacion', type: 'string'}
    ],

    proxy: {
        type: 'ajax',
        api: {
            create: 'iiMantenimiento',
            read: 'mantenimientos',
            update: 'uuMantenimiento',
            destroy: 'ddMantenimiento'
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
