Ext.define('GrupoBruce.model.Almuerzo', {
    extend: 'Ext.data.Model',
    alias: 'model.Malmuerzo',

    idProperty: 'idTrabajador',
    fields: [
        {name: 'enComedor', type: 'boolean'},
        {name: 'fecha', type: 'date', dateFormat: 'c'},
        {name: 'idTrabajador', type: 'string'},
        {name: 'procesado', type: 'boolean'},
        {name: 'refrigerio', type: 'boolean'},
        {name: 'trabajador', type: 'string'}
    ],
    proxy: {
        type: 'ajax',
        api: {
            create: 'iiAlmuerzo',
            read: 'almuerzos',
            update: 'uuAlmuerzo',
            destroy: 'ddAlmuerzo'
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
