Ext.define('GrupoBruce.model.Mantenimiento', {
    extend: 'Ext.data.Model',
    alias: 'model.Mmantenimiento',
    
    idProperty: 'idMantenimiento',
    fields: [
        {name: 'costo', type: 'float'},
        {name: 'fecha', type: 'date', dateFormat :'c'},
        {name: 'fechaAtendido', type: 'date', dateFormat :'c'},
        {name: 'fechaProgramada', type: 'date', dateFormat :'c'},
        {name: 'idAequipo', type: 'string'},
        {name: 'idMantenimiento', type: 'string'},
        {name: 'idTmantenimiento', type: 'string'},
        {name: 'idEmantenimiento', type: 'string'},
        {name: 'observacion', type: 'string'},
        {name: 'idGenerador', type: 'string'}
    ],
    
    identifier: 'sequential',

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
